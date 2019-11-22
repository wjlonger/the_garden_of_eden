package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.vo.OnlineNeedDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineNeedDetailMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OnlineNeedDetail record);

    int insertSelective(OnlineNeedDetail record);

    OnlineNeedDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineNeedDetail record);

    int updateByPrimaryKey(OnlineNeedDetail record);

    List<OnlineNeedDetailVo> selectByNeedId(@Param("needId") Integer needId);

    List<OnlineNeedDetailVo> selectByNeedIds(@Param("needIds") List<Integer> needIds);

    List<OnlineNeedDetailVo> selectByAppId(@Param("appId") Integer appId);
}
