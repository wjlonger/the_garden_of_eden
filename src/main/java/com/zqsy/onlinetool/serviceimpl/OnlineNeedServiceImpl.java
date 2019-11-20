package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineAppMapper;
import com.zqsy.onlinetool.mapper.OnlineNeedMapper;
import com.zqsy.onlinetool.model.OnlineApp;
import com.zqsy.onlinetool.model.OnlineNeed;
import com.zqsy.onlinetool.service.OnlineAppService;
import com.zqsy.onlinetool.service.OnlineNeedService;
import com.zqsy.onlinetool.vo.OnlineNeedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("onlineNeedService")
public class OnlineNeedServiceImpl implements OnlineNeedService {

    @Autowired
    private OnlineNeedMapper onlineNeedMapper;

    @Override
    public int create(OnlineNeed onlineNeed) {
        return this.onlineNeedMapper.insertSelective(onlineNeed);
    }

    @Override
    public int delete(Integer id) {
        return this.onlineNeedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(OnlineNeed onlineNeed) {
        return this.onlineNeedMapper.updateByPrimaryKeySelective(onlineNeed);
    }

    @Override
    public List<OnlineNeedVo> selectByAppIds(List<Integer> appIds) {
        return this.onlineNeedMapper.selectByAppIds(appIds);
    }
}
