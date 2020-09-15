package com.vicente.lightmall.mapper;

import com.vicente.lightmall.entity.Permission;
import com.vicente.lightmall.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色资源表 Mapper 接口
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    List<Permission> findByUserName(String userName);
}
