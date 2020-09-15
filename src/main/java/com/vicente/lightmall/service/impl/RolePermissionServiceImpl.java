package com.vicente.lightmall.service.impl;

import com.vicente.lightmall.entity.Permission;
import com.vicente.lightmall.entity.RolePermission;
import com.vicente.lightmall.mapper.RolePermissionMapper;
import com.vicente.lightmall.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Permission> findByUserName(String userName) {
        return rolePermissionMapper.findByUserName(userName);
    }
}
