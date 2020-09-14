package com.vicente.lightmall.service;

import com.vicente.lightmall.entity.LightUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vicente
 * @since 2020-09-11
 */
public interface LightUserService extends IService<LightUser> {

    List<LightUser> getAllUser();

    LightUser findByUserName(String userName);
}
