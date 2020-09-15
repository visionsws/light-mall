package com.vicente.lightmall.controller;


import com.vicente.lightmall.common.ResultBean;
import com.vicente.lightmall.entity.Permission;
import com.vicente.lightmall.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色资源表 前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@RestController
@RequestMapping("/role-permission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping("/findByUserName")
    public ResultBean findByUserName(String userName){
        List<Permission> list = rolePermissionService.findByUserName(userName);
        return new ResultBean(list);


    }

}
