package com.zqsy.onlinetool.controller;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.service.OnlinePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/password/")
public class OnlinePasswordController {

    @Autowired
    private OnlinePasswordService onlinePasswordService;

    @GetMapping("/{id}")
    public JSONObject getPassword(@PathVariable("id") Integer id, @RequestParam("httpToken") String httpToken){
        return onlinePasswordService.getPassword(id,httpToken);
    }
}
