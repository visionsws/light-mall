package com.vicente.lightmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vicente.lightmall.entity.LightUser;
import com.vicente.lightmall.mapper.LightUserMapper;
import com.vicente.lightmall.service.LightUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vicente
 * @since 2020-09-11
 */
@Service
@Slf4j
public class LightUserServiceImpl extends ServiceImpl<LightUserMapper, LightUser> implements LightUserService {


    @Override
    public List<LightUser> getAllUser() {
        log.info("1111111111111222222222222222222333333");
        return this.baseMapper.selectList(new QueryWrapper<LightUser>());
    }

    @Override
    public LightUser findByUserName(String userName) {
        return this.baseMapper.selectOne(new QueryWrapper<LightUser>().eq("user_name",userName));
    }

}
