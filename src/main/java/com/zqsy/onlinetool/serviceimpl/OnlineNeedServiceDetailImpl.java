package com.zqsy.onlinetool.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.mapper.OnlineNeedDetailMapper;
import com.zqsy.onlinetool.model.OnlineFinish;
import com.zqsy.onlinetool.model.OnlineNeedDetail;
import com.zqsy.onlinetool.service.OnlineFinishService;
import com.zqsy.onlinetool.service.OnlineNeedDetailService;
import com.zqsy.onlinetool.service.OnlinePasswordService;
import com.zqsy.onlinetool.vo.OnlineFinishVo;
import com.zqsy.onlinetool.vo.OnlineNeedDetaiForFinishlVo;
import com.zqsy.onlinetool.vo.OnlineNeedDetailVo;
import com.zqsy.onlinetool.vo.OnlineNeedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service("onlineNeedDetailService")
public class OnlineNeedServiceDetailImpl implements OnlineNeedDetailService {

    @Autowired
    private OnlineNeedDetailMapper onlineNeedDetailMapper;

    @Autowired
    private OnlinePasswordService onlinePasswordService;

    @Autowired
    private OnlineFinishService onlineFinishService;

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

    @Override
    public JSONObject detail(Integer appId, String password) {
        JSONObject jsonObject = new JSONObject();
        boolean passwordCorrect = this.onlinePasswordService.chenckPassword(appId, password);
        if(passwordCorrect){
            List<OnlineNeedDetaiForFinishlVo> needVos = this.onlineNeedDetailMapper.selectByAppId(appId);
            if(null != needVos && !needVos.isEmpty()){
                List<OnlineFinishVo> finishVos = this.onlineFinishService.selectByAppId(appId);
                needVos.forEach(onlineNeedDetaiForFinishlVo -> {
                    onlineNeedDetaiForFinishlVo.setOnlineFinishVo(finishVos.stream().filter(onlineFinishVo ->  onlineNeedDetaiForFinishlVo.getProjectName().equals(onlineFinishVo.getOnlineAppName())).findFirst().orElse(null));
                });
                jsonObject.put("success", true);
                jsonObject.put("data", needVos);
            } else {
                jsonObject.put("success", false);
                jsonObject.put("msg", "研发同学还未填写上线应用哦~");
            }
        } else {
            jsonObject.put("success", false);
            jsonObject.put("msg", "密码错误");
        }
        return jsonObject;
    }
}
