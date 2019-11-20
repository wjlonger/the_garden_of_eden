package com.zqsy.onlinetool.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zqsy.onlinetool.model.OnlineApp;
import com.zqsy.onlinetool.service.OnlineAppService;
import com.zqsy.onlinetool.vo.OnlineAppVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/onlineapp")
public class OnlineAppController {

    @Autowired
    private OnlineAppService onlineAppService;

    @GetMapping("/{pageIndex}/{pageSize}")
    public PageInfo<OnlineAppVo> list(@PathVariable("pageIndex") Integer pageIndex,
                                      @PathVariable("pageSize") Integer pageSize){
        return PageHelper.startPage(pageIndex,pageSize)
                .setOrderBy("date desc,time desc").doSelectPageInfo(() -> this.onlineAppService.list(null));
    }

    @GetMapping
    public PageInfo<OnlineAppVo> list(@RequestParam(value = "pageIndex",defaultValue = "1", required = false) Integer pageIndex,
                                    @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
                                    @RequestParam(value = "lastId", required = false) Integer lastId){
        return PageHelper.startPage(pageIndex,pageSize)
                .setOrderBy("id desc")
                .doSelectPageInfo(() -> this.onlineAppService.list(lastId));
    }

    @PostMapping
    public void create(@RequestBody OnlineApp onlineApp){
        this.onlineAppService.create(onlineApp);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable("id") Integer id){
        this.onlineAppService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody OnlineApp onlineApp){
        this.onlineAppService.update(onlineApp);
    }

}
