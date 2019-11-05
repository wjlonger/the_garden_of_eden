package com.zqsy.onlinetool.controller;

import com.zqsy.onlinetool.model.OnlineNeed;
import com.zqsy.onlinetool.service.OnlineNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/onlineneed")
public class OnlineNeedController {

    @Autowired
    private OnlineNeedService onlineNeedService;

    @PostMapping
    public Integer create (@RequestBody OnlineNeed onlineNeed){
        this.onlineNeedService.create(onlineNeed);
        return onlineNeed.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        this.onlineNeedService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody OnlineNeed onlineNeed){
        this.onlineNeedService.update(onlineNeed);
    }

    @PutMapping("/{needId}/{appId}")
    public void modifyAppId(@PathVariable("needId") Integer needId,@PathVariable("appId") Integer appId){
        OnlineNeed onlineNeed = new OnlineNeed();
        onlineNeed.setId(needId);
        onlineNeed.setAppId(appId);
        onlineNeedService.update(onlineNeed);
    }

}
