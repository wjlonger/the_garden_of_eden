package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineAppMapper;
import com.zqsy.onlinetool.model.OnlineApp;
import com.zqsy.onlinetool.service.OnlineAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("onlineAppService")
public class OnlineAppServiceImpl implements OnlineAppService {

    @Autowired
    private OnlineAppMapper onlineAppMapper;

    @Override
    public List<OnlineApp> list(Integer lastId){
        return this.onlineAppMapper.list(lastId);
    }

    @Override
    public int create(OnlineApp onlineApp) {
        return this.onlineAppMapper.insert(onlineApp);
    }

    @Override
    public int delete(Integer id) {
        return this.onlineAppMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(OnlineApp onlineApp) {
        return this.onlineAppMapper.updateByPrimaryKeySelective(onlineApp);
    }
}
