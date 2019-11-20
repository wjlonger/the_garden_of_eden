package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.vo.OnlineNeedDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineNeedDetailService {

    int create(OnlineNeedDetail onlineNeedDetail);

    int delete(Integer id);

    int update(OnlineNeedDetail onlineNeedDetail);

    List<OnlineNeedDetailVo> selectByNeedIds(@Param("needIds") List<Integer> neeIds);
}
