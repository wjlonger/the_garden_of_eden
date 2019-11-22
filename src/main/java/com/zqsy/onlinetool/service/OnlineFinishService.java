package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.vo.OnlineFinishVo;

import java.util.List;

public interface OnlineFinishService {

    List<OnlineFinishVo> selectByAppId(Integer appId);

}
