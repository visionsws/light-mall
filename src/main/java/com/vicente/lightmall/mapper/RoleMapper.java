package com.vicente.lightmall.mapper;

import com.vicente.lightmall.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findByUserName(String userName);

}
