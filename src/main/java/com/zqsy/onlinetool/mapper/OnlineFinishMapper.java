package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineFinish;
import com.zqsy.onlinetool.vo.OnlineFinishVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineFinishMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OnlineFinish record);

    int insertSelective(OnlineFinish record);

    OnlineFinish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineFinish record);

    int updateByPrimaryKey(OnlineFinish record);

    List<OnlineFinishVo> selectByAppId(@Param("appId") Integer appId);

    OnlineFinish selectByAppIdByProjectNameByArea(@Param("appId") Integer appId, @Param("onlineAppName") String onlineAppName, @Param("area") String area);

}
