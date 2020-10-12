package com.vicente.lightmall.controller;


import com.vicente.lightmall.common.ResultBean;
import com.vicente.lightmall.service.RoleService;
import com.vicente.lightmall.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Api(tags = "RoleController", description = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @ApiOperation("获取所有角色列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean getRoleList() {
        return ResultBean.SUCCESS;
    }


}
