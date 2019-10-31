package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeed;

public interface OnlineNeedService {

    int create(OnlineNeed onlineNeed);

    int delete(Integer id);

    int update(OnlineNeed onlineNeed);
}
