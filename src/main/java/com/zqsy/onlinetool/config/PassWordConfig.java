package com.zqsy.onlinetool.config;

import com.zqsy.onlinetool.model.OnlinePassword;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;

@Configuration
public class PassWordConfig {

    @Bean("passwords")
    @Scope("singleton")
    public HashMap<Integer, OnlinePassword> passwords(){
        return new HashMap<>();
    }

}
