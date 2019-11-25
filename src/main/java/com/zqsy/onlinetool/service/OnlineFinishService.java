package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineFinish;
import com.zqsy.onlinetool.vo.OnlineFinishVo;

import java.util.List;

public interface OnlineFinishService {

    int insert(OnlineFinish onlineFinish);

    int update(OnlineFinish onlineFinish);

    List<OnlineFinishVo> selectByAppId(Integer appId);

    OnlineFinish selectByAppIdByProjectNameByArea(Integer appId, String projectName, String area);
}
