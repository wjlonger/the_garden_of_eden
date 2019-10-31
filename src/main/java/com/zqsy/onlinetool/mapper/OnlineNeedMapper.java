package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineNeed;
import com.zqsy.onlinetool.vo.OnlineNeedVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineNeedMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OnlineNeed record);

    int insertSelective(OnlineNeed record);

    OnlineNeed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineNeed record);

    int updateByPrimaryKey(OnlineNeed record);

    List<OnlineNeedVo> selectByAppId(@Param("appId") Integer appId);
}