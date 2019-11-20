package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.OnlineNeedRemarkMapper;
import com.zqsy.onlinetool.model.OnlineNeedRemark;
import com.zqsy.onlinetool.service.OnlineNeedRemarkService;
import com.zqsy.onlinetool.vo.OnlineNeedRemarkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("onlineNeedRemarkService")
public class OnlineNeedRemarkServiceImpl implements OnlineNeedRemarkService {

    @Autowired
    private OnlineNeedRemarkMapper onlineNeedRemarkMapper;

    @Override
    public int create(OnlineNeedRemark onlineNeedRemark) {
        return this.onlineNeedRemarkMapper.insertSelective(onlineNeedRemark);
    }

    @Override
    public int delete(Integer id) {
        return this.onlineNeedRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(OnlineNeedRemark onlineNeedRemark) {
        return this.onlineNeedRemarkMapper.updateByPrimaryKeySelective(onlineNeedRemark);
    }

    @Override
    public List<OnlineNeedRemarkVo> selectByNeedIds(List<Integer> needIds) {
        return this.onlineNeedRemarkMapper.selectByNeedIds(needIds);
    }
}
