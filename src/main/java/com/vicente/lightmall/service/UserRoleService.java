package com.vicente.lightmall.service;

import com.vicente.lightmall.entity.Role;
import com.vicente.lightmall.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
public interface UserRoleService extends IService<UserRole> {

    List<Role> getUserRole(String name);

}
