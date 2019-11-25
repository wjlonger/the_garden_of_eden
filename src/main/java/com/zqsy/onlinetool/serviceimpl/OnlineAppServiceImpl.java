package com.zqsy.onlinetool.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.adam.client.AdamClient;
import com.zqsy.onlinetool.adam.request.TaskBuildAdamRequest;
import com.zqsy.onlinetool.mapper.OnlineAppMapper;
import com.zqsy.onlinetool.model.OnlineApp;
import com.zqsy.onlinetool.model.OnlineFinish;
import com.zqsy.onlinetool.model.OnlinePassword;
import com.zqsy.onlinetool.service.*;
import com.zqsy.onlinetool.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("onlineAppService")
public class OnlineAppServiceImpl implements OnlineAppService {

    @Autowired
    private OnlineAppMapper onlineAppMapper;

    @Autowired
    private OnlineNeedService onlineNeedService;

    @Autowired
    private OnlineNeedDetailService onlineNeedDetailService;

    @Autowired
    private OnlineNeedRemarkService onlineNeedRemarkService;

    @Autowired
    private FileService fileService;

    @Autowired
    private OnlineFinishService onlineFinishService;

    @Autowired
    private AdamClient adamClient;

    @Autowired
    private HashMap<Integer, OnlinePassword> passwords;

    @Autowired
    private OnlinePasswordService onlinePasswordService;

    @Override
    public List<OnlineAppVo> list(Integer lastId){
        List<OnlineAppVo> apps = this.onlineAppMapper.list(lastId);
        if(null != apps && !apps.isEmpty()){
            List<Integer> appIds = apps.stream().map(OnlineAppVo::getId).distinct().collect(Collectors.toList());
            if(null != appIds && !appIds.isEmpty()){
                List<OnlineNeedVo> needs = onlineNeedService.selectByAppIds(appIds);
                List<UploadFileInfoVo> files = fileService.selectByAppIds(appIds);
                Map<Integer, List<OnlineNeedVo>> needMap;
                Map<Integer, List<UploadFileInfoVo>> fileMap;
                if(null != needs && !needs.isEmpty()){
                    List<Integer> needIds = needs.stream(). map(OnlineNeedVo::getId).distinct().collect(Collectors.toList());
                    if(null != needIds && !needIds.isEmpty()){
                        List<OnlineNeedDetailVo> details = onlineNeedDetailService.selectByNeedIds(needIds);
                        List<OnlineNeedRemarkVo> remarks = onlineNeedRemarkService.selectByNeedIds(needIds);
                        Map<Integer, List<OnlineNeedDetailVo>> detailMap;
                        Map<Integer, List<OnlineNeedRemarkVo>> remarkMap;
                        if(null != details && !details.isEmpty()){
                            detailMap = details.stream().collect(Collectors.groupingBy(OnlineNeedDetailVo::getNeedId));
                        } else {
                            detailMap = new HashMap<>();
                        }
                        if(null != remarks && !remarks.isEmpty()){
                            remarkMap = remarks.stream().collect(Collectors.groupingBy(OnlineNeedRemarkVo::getNeedId));
                        } else {
                            remarkMap = new HashMap<>();
                        }
                        for(OnlineNeedVo needVo : needs){
                            needVo.setNeeds(detailMap.getOrDefault(needVo.getId(),new ArrayList<>()));
                            needVo.setRemarks(remarkMap.getOrDefault(needVo.getId(),new ArrayList<>()));
                        }
                        needMap = needs.stream().collect(Collectors.groupingBy(OnlineNeedVo::getAppId));
                    } else {
                        needMap = new HashMap<>();
                    }
                } else {
                    needMap = new HashMap<>();
                }
                if(null != files && !files.isEmpty()){
                    fileMap = files.stream().collect(Collectors.groupingBy(UploadFileInfoVo::getAppId));
                } else {
                    fileMap = new HashMap<>();
                }
                for(OnlineAppVo app: apps){
                    app.setNeedList(needMap.getOrDefault(app.getId(), new ArrayList<>()));
                    app.setFileList(fileMap.getOrDefault(app.getId(), new ArrayList<>()));
                }
            }
        }
        return apps;
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

    @Override
    public JSONObject build(OnlineAppBuildVo onlineAppBuildVo) {
        JSONObject jsonObject = new JSONObject();
        boolean passwordCorrect = this.onlinePasswordService.chenckPassword(onlineAppBuildVo.getAppId(), onlineAppBuildVo.getPassword());
        if(!passwordCorrect){
            jsonObject.put("success", false);
            jsonObject.put("msg", "密码错误");
            return jsonObject;
        }
        TaskBuildAdamRequest taskBuildRequest = new TaskBuildAdamRequest();
        taskBuildRequest.setRegion(onlineAppBuildVo.getRegion());
        taskBuildRequest.setTaskName(onlineAppBuildVo.getTaskName());
        taskBuildRequest.setHttpToken(onlineAppBuildVo.getHttpToken());
        taskBuildRequest.setToken(passwords.get(onlineAppBuildVo.getAppId()).getAccessToken());
        if(!StringUtils.isEmpty(onlineAppBuildVo.getTag())){
            taskBuildRequest.setParams(new HashMap<String, Object>(){{
                put("Tag", onlineAppBuildVo.getTag());
            }});
        }
        adamClient.execute(taskBuildRequest);
        OnlineFinish onlineFinish = this.onlineFinishService.selectByAppIdByProjectNameByArea(onlineAppBuildVo.getAppId(), onlineAppBuildVo.getTaskName(), onlineAppBuildVo.getRegion());
        if(null == onlineFinish) {
            onlineFinish = new OnlineFinish();
            onlineFinish.setAppId(onlineAppBuildVo.getAppId());
            onlineFinish.setArea(onlineAppBuildVo.getRegion());
            onlineFinish.setOnlineAppName(onlineAppBuildVo.getTaskName());
            onlineFinish.setOnlineVersion(onlineAppBuildVo.getTag());
            onlineFinish.setUpdateTime(System.currentTimeMillis());
            this.onlineFinishService.insert(onlineFinish);
        } else {
            onlineFinish.setArea(onlineAppBuildVo.getRegion());
            onlineFinish.setOnlineAppName(onlineAppBuildVo.getTaskName());
            onlineFinish.setOnlineVersion(onlineAppBuildVo.getTag());
            onlineFinish.setUpdateTime(System.currentTimeMillis());
            this.onlineFinishService.update(onlineFinish);
        }
        jsonObject.put("success", true);
        jsonObject.put("msg", "构建成功");
        return jsonObject;
    }
}
