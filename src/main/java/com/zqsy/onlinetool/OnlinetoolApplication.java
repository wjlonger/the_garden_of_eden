package com.zqsy.onlinetool;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.zqsy.onlinetool.mapper")
public class OnlinetoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinetoolApplication.class, args);
    }


    @Bean("jsonObject")
    public JSONObject jsonObject(){
        return new JSONObject();
    }

}
