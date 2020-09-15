package com.vicente.lightmall.controller;

import com.alibaba.fastjson.JSON;
import com.vicente.lightmall.common.ResultBean;
import com.vicente.lightmall.entity.LightUser;
import com.vicente.lightmall.service.LightUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LightUserService lightUserService;

    @GetMapping("/login")
    public String login() {
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "login";
    }

    @PostMapping("/loginBy")
    @ResponseBody
    public ResultBean loginBy(String username,String password){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username,
                password
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultBean.FAIL;
        }
        Session session = subject.getSession();
        System.out.println(session.getAttribute("userName"));
        if (subject.isAuthenticated()){
            session.setAttribute("userName",username);
        }else {
            session.removeAttribute("userName");
        }
        return new ResultBean("登陆成功");
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        LightUser user = (LightUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }


    @RequestMapping("/getAllUser")
    public String getAllUser(){
        List<LightUser> allUser = lightUserService.getAllUser();
        return JSON.toJSONString(allUser);
    }

    @RequestMapping("/403")
    public String error403(){
        return "403";
    }
}
