package com.zqsy.onlinetool.service;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.model.OnlineApp;
import com.zqsy.onlinetool.vo.OnlineAppBuildVo;
import com.zqsy.onlinetool.vo.OnlineAppVo;

import java.util.List;

public interface OnlineAppService {

    List<OnlineAppVo> list(Integer lastId);

    int create(OnlineApp onlineApp);

    int delete(Integer id);

    int update(OnlineApp onlineApp);

    JSONObject build(OnlineAppBuildVo onlineAppBuildVo);
}
