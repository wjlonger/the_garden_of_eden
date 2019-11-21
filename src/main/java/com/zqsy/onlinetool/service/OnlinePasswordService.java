package com.zqsy.onlinetool.service;

import com.alibaba.fastjson.JSONObject;

public interface OnlinePasswordService {

    JSONObject getPassword(Integer id, String httpToken);

}
