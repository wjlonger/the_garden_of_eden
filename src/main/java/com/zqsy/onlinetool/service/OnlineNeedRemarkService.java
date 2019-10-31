package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeedRemark;

public interface OnlineNeedRemarkService {

    int create(OnlineNeedRemark onlineNeedRemark);

    int delete(Integer id);

    int update(OnlineNeedRemark onlineNeedRemark);
}
