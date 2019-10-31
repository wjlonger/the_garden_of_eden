package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineNeedRemark;

public interface OnlineNeedRemarkMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OnlineNeedRemark record);

    int insertSelective(OnlineNeedRemark record);

    OnlineNeedRemark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineNeedRemark record);

    int updateByPrimaryKeyWithBLOBs(OnlineNeedRemark record);

    int updateByPrimaryKey(OnlineNeedRemark record);
}