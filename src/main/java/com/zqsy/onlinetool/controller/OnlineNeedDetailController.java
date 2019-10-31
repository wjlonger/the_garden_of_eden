package com.zqsy.onlinetool.controller;

import com.zqsy.onlinetool.model.OnlineNeed;
import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.service.OnlineNeedDetailService;
import com.zqsy.onlinetool.service.OnlineNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/onlineneeddetail")
public class OnlineNeedDetailController {

    @Autowired
    private OnlineNeedDetailService onlineNeedDetailService;

    @PostMapping
    public Integer create (@RequestBody OnlineNeedDetail onlineNeedDetail){
        this.onlineNeedDetailService.create(onlineNeedDetail);
        return onlineNeedDetail.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        this.onlineNeedDetailService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody OnlineNeedDetail onlineNeedDetail){
        this.onlineNeedDetailService.update(onlineNeedDetail);
    }

}
