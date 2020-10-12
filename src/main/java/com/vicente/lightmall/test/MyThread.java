package com.vicente.lightmall.test;

import com.alibaba.fastjson.JSON;
import com.vicente.lightmall.entity.User;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class MyThread {
    private static User user;
    static {
        user = new User();
        user.setId(1111);
        user.setAccount("username");
        user.setUsername("xiaohong");
        user.setPassword("aaaaaa");
        user.setRegTime(LocalDateTime.now());
    }

    public static void main(String[] args) {
        User myUser = new User();
        BeanUtils.copyProperties(user,myUser,"username","account");
        //myUser = user;
        myUser.setId(2222);
        System.out.println("user"+JSON.toJSONString(user));
        System.out.println("myuser"+JSON.toJSONString(myUser));
    }
}
