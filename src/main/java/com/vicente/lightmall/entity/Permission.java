package com.vicente.lightmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 权限代码字符串
     */
    private String perCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
