package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineApp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineAppMapper {

    List<OnlineApp> list(@Param("lastId") Integer lastId);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(OnlineApp record);

    int insertSelective(OnlineApp record);

    OnlineApp selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(OnlineApp record);

    int updateByPrimaryKey(OnlineApp record);

}