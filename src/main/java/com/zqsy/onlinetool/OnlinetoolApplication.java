package com.zqsy.onlinetool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zqsy.onlinetool.mapper")
public class OnlinetoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinetoolApplication.class, args);
    }

}
