package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineFinishMapper;
import com.zqsy.onlinetool.model.OnlineFinish;
import com.zqsy.onlinetool.service.OnlineFinishService;
import com.zqsy.onlinetool.vo.OnlineFinishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("onlineFinishService")
public class OnlineFinishSrviceImpl implements OnlineFinishService {

    @Autowired
    private OnlineFinishMapper onlineFinishMapper;

    @Override
    public int insert(OnlineFinish onlineFinish) {
        return this.onlineFinishMapper.insertSelective(onlineFinish);
    }

    @Override
    public int update(OnlineFinish onlineFinish) {
        return this.onlineFinishMapper.updateByPrimaryKeySelective(onlineFinish);
    }

    @Override
    public List<OnlineFinishVo> selectByAppId(Integer appId) {
        return this.onlineFinishMapper.selectByAppId(appId);
    }

    @Override
    public OnlineFinish selectByAppIdByProjectNameByArea(Integer appId, String projectName, String area) {
        return this.onlineFinishMapper.selectByAppIdByProjectNameByArea(appId, projectName, area);
    }
}
