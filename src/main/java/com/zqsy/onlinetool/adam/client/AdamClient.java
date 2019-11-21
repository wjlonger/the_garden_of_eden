package com.zqsy.onlinetool.adam.client;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.adam.request.TaskBuildAdamRequest;
import com.zqsy.onlinetool.adam.request.TokenApplyRequest;
import com.zqsy.onlinetool.adam.response.TaskBuildResponse;
import com.zqsy.onlinetool.adam.response.TokenApplyResponse;
import com.zqsy.onlinetool.model.OnlinePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private HttpHeaders httpHeaders;

    public TaskBuildResponse execute(TaskBuildAdamRequest taskBuildRequest){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", taskBuildRequest.getToken());
        hashMap.put("region",taskBuildRequest.getRegion());
        hashMap.put("taskName", taskBuildRequest.getTaskName());
        hashMap.put("params", JSONObject.toJSONString(taskBuildRequest.getParams()));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
        httpHeaders.add("Authorization",taskBuildRequest.getHttpToken());
        HttpEntity<HashMap<String, String>> httpEntity = new HttpEntity<>(hashMap, httpHeaders);
        return restTemplate.postForObject(buildServiceUrl, httpEntity, TaskBuildResponse.class);
    }

    public String execute(TokenApplyRequest tokenApplyRequest){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("deployId", String.valueOf(tokenApplyRequest.getId()));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
        httpHeaders.add("Authorization",tokenApplyRequest.getHttpToken());
        HttpEntity<HashMap<String, String>> httpEntity = new HttpEntity<>(hashMap, httpHeaders);
        return restTemplate.postForObject(tokenServiceUrl, httpEntity, String.class);
    }

}
