package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.OnlineNeedRemark;
import com.zqsy.onlinetool.vo.OnlineNeedRemarkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineNeedRemarkMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OnlineNeedRemark record);

    int insertSelective(OnlineNeedRemark record);

    OnlineNeedRemark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineNeedRemark record);

    int updateByPrimaryKeyWithBLOBs(OnlineNeedRemark record);

    int updateByPrimaryKey(OnlineNeedRemark record);

    List<OnlineNeedRemarkVo> selectByNeedIds(@Param("needIds") List<Integer> needIds);
}
