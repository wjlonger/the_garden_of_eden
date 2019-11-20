package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineNeedDetailMapper;
import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.service.OnlineNeedDetailService;
import com.zqsy.onlinetool.vo.OnlineNeedDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("onlineNeedDetailService")
public class OnlineNeedServiceDetailImpl implements OnlineNeedDetailService {

    @Autowired
    private OnlineNeedDetailMapper onlineNeedDetailMapper;

    @Override
    public int create(OnlineNeedDetail onlineNeedDetail) {
        return this.onlineNeedDetailMapper.insertSelective(onlineNeedDetail);
    }

    @Override
    public int delete(Integer id) {
        return this.onlineNeedDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(OnlineNeedDetail onlineNeedDetail) {
        return this.onlineNeedDetailMapper.updateByPrimaryKeySelective(onlineNeedDetail);
    }

    @Override
    public List<OnlineNeedDetailVo> selectByNeedIds(List<Integer> needIds) {
        return this.onlineNeedDetailMapper.selectByNeedIds(needIds);
    }
}
