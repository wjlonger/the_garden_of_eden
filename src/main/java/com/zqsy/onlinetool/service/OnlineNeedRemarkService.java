package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeedRemark;
import com.zqsy.onlinetool.vo.OnlineNeedRemarkVo;

import java.util.List;

public interface OnlineNeedRemarkService {

    int create(OnlineNeedRemark onlineNeedRemark);

    int delete(Integer id);

    int update(OnlineNeedRemark onlineNeedRemark);

    List<OnlineNeedRemarkVo> selectByNeedIds(List<Integer> needIds);
}
