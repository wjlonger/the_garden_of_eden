package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeed;
import com.zqsy.onlinetool.vo.OnlineNeedVo;

import java.util.List;

public interface OnlineNeedService {

    int create(OnlineNeed onlineNeed);

    int delete(Integer id);

    int update(OnlineNeed onlineNeed);

    List<OnlineNeedVo> selectByAppIds(List<Integer> appIds);
}
