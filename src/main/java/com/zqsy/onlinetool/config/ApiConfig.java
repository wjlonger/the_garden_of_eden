package com.zqsy.onlinetool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("httpHeaders")
    public HttpHeaders httpHeaders(){
        return new HttpHeaders();
    }

}
