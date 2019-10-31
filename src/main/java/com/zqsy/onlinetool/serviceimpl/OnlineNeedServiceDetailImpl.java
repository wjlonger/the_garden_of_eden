package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineNeedDetailMapper;
import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.service.OnlineNeedDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
