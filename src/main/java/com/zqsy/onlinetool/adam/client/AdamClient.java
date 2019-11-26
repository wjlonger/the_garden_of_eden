package com.zqsy.onlinetool.adam.client;

import com.zqsy.onlinetool.adam.request.TaskBuildAdamRequest;
import com.zqsy.onlinetool.adam.request.TokenApplyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Configuration
public class AdamClient {

    @Value("${adam.tokenServiceUrl}")
    private String tokenServiceUrl;

    @Value("${adam.buildServiceUrl}")
    private String buildServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void execute(TaskBuildAdamRequest taskBuildRequest){
        restTemplate.postForObject(buildServiceUrl, new HttpEntity<>(new HashMap<String, Serializable>(){{
            put("token", taskBuildRequest.getToken());
            put("region",taskBuildRequest.getRegion());
            put("taskName", taskBuildRequest.getTaskName());
            if(null != taskBuildRequest.getParams() && !taskBuildRequest.getParams().isEmpty()){
                put("params", taskBuildRequest.getParams());
            }
        }}, new HttpHeaders(){{
            setContentType(MediaType.APPLICATION_JSON_UTF8);
            add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
            add("Authorization",taskBuildRequest.getHttpToken());
        }}), String.class);
    }

    public String execute(TokenApplyRequest tokenApplyRequest){
        return restTemplate.postForObject(tokenServiceUrl, new HttpEntity<>(new HashMap<String, Serializable>(){{
            put("deployId", String.valueOf(tokenApplyRequest.getId()));
        }}, new HttpHeaders(){{
            setContentType(MediaType.APPLICATION_JSON_UTF8);
            add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
            add("Authorization",tokenApplyRequest.getHttpToken());
        }}), String.class);
    }

}
