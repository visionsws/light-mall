package com.vicente.lightmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vicente.lightmall.mapper")
public class LightMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightMallApplication.class, args);
    }

}
