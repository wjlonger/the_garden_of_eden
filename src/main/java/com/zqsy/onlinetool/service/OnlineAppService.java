package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineApp;

import java.util.List;

public interface OnlineAppService {

    List<OnlineApp> list(Integer lastId);

    int create(OnlineApp onlineApp);

    int delete(Integer id);

    int update(OnlineApp onlineApp);
}
