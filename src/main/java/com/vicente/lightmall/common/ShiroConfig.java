package com.vicente.lightmall.common;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //将自己的验证方式加入容器
    @Bean
    public ShiroRealm myShiroRealm() {
        ShiroRealm customRealm = new ShiroRealm();
        return customRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(){
        // 配置SecurityManager，并注入shiroRealm
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        //log.info("进入shiroFilter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.html"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/light-user/**", "anon");
        filterChainDefinitionMap.put("/loginBy", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        // 根据用户的角色赋予相应的权限
        // filterChainDefinitionMap.put("/add", "roles[admin]");
        // filterChainDefinitionMap.put("/delete", "roles[admin]");
        // filterChainDefinitionMap.put("/delete", "roles[author]");
        filterChainDefinitionMap.put("/addPermission", "roles[author]");
        filterChainDefinitionMap.put("/add", "perms[user:add]");
        filterChainDefinitionMap.put("/user/delete", "perms[user:delete]");
        filterChainDefinitionMap.put("/userList", "perms[user:list]");
        // 匹配所有的路径
        // 通过Map集合组成了一个拦截器链 ，自顶向下过滤，一旦匹配，则不再执行下面的过滤
        // 如果下面的定义与上面冲突，那按照了谁先定义谁说了算
        // 一定要配置在最后
        filterChainDefinitionMap.put("/**", "user");
        // 将拦截器链设置到shiro中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * cookie对象
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
