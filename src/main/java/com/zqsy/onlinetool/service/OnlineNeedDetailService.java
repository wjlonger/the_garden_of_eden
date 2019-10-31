package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeedDetail;

public interface OnlineNeedDetailService {

    int create(OnlineNeedDetail onlineNeedDetail);

    int delete(Integer id);

    int update(OnlineNeedDetail onlineNeedDetail);
}
