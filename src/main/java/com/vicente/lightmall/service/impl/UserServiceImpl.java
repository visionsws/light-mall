package com.vicente.lightmall.service.impl;

import com.vicente.lightmall.entity.User;
import com.vicente.lightmall.mapper.UserMapper;
import com.vicente.lightmall.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author vicente
 * @since 2020-09-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
