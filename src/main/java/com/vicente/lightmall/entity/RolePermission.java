package com.vicente.lightmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色资源表
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permissionId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
