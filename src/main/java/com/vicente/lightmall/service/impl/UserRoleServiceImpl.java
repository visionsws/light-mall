package com.vicente.lightmall.service.impl;

import com.vicente.lightmall.entity.Role;
import com.vicente.lightmall.entity.UserRole;
import com.vicente.lightmall.mapper.RoleMapper;
import com.vicente.lightmall.mapper.UserRoleMapper;
import com.vicente.lightmall.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getUserRole(String name){
        return roleMapper.findByUserName(name);
    }

}
