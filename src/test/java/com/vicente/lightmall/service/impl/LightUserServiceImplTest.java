package com.vicente.lightmall.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LightUserServiceImplTest {

    @Test
    void getAllUser() {
        // 获得当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 将当前时间转为时间戳
        long second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        // 1580706475
        System.out.println(second);
    }

}