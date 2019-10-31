package com.zqsy.onlinetool.controller;

import com.zqsy.onlinetool.model.OnlineNeedRemark;
import com.zqsy.onlinetool.service.OnlineNeedRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/onlineneedremark")
public class OnlineNeedRemarklController {

    @Autowired
    private OnlineNeedRemarkService onlineNeedRemarkService;

    @PostMapping
    public Integer create (@RequestBody OnlineNeedRemark onlineNeedRemark){
        this.onlineNeedRemarkService.create(onlineNeedRemark);
        return onlineNeedRemark.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        this.onlineNeedRemarkService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody OnlineNeedRemark onlineNeedRemark){
        this.onlineNeedRemarkService.update(onlineNeedRemark);
    }

}
