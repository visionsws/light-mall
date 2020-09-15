package com.vicente.lightmall.service;

import com.vicente.lightmall.entity.Permission;
import com.vicente.lightmall.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
public interface RolePermissionService extends IService<RolePermission> {

    List<Permission> findByUserName(String userName);
}
