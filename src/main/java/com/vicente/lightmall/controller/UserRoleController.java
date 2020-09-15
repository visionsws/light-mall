package com.vicente.lightmall.controller;


import com.vicente.lightmall.common.ResultBean;
import com.vicente.lightmall.entity.LightUser;
import com.vicente.lightmall.entity.Role;
import com.vicente.lightmall.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Controller
@RequestMapping("/user")
public class UserRoleController {


    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("findRoleByName")
    public ResultBean findRoleByName(String userName){
        List<Role> userRole = userRoleService.getUserRole(userName);
        return new ResultBean(userRole);
    }

    @RequiresPermissions("user:user")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        LightUser user = (LightUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        LightUser user = (LightUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        LightUser user = (LightUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }

}
