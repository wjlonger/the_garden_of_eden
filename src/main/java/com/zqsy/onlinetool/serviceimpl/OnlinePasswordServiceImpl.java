package com.zqsy.onlinetool.serviceimpl;


import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.adam.client.AdamClient;
import com.zqsy.onlinetool.adam.request.TokenApplyRequest;
import com.zqsy.onlinetool.dingtalk.client.DingTalkClient;
import com.zqsy.onlinetool.model.OnlinePassword;
import com.zqsy.onlinetool.service.OnlinePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.UUID;

@Service("onlinePasswordService")
public class OnlinePasswordServiceImpl implements OnlinePasswordService {

    private static final long expireTime = 1000L * 60L * 60L * 2L;

    @Autowired
    private HashMap<Integer, OnlinePassword> passwords;

    @Autowired
    private AdamClient adamClient;

    @Autowired
    private DingTalkClient dingTalkClient;

    @Override
    public JSONObject getPassword(Integer id, String httpToken) {
        JSONObject jsonObject = new JSONObject();
        OnlinePassword password = passwords.get(id);
        if(null == password || password.getExpireDate() < System.currentTimeMillis()){
            TokenApplyRequest tokenApplyRequest = new TokenApplyRequest();
            tokenApplyRequest.setId(id);
            tokenApplyRequest.setHttpToken(httpToken);
            String token = adamClient.execute(tokenApplyRequest);
            if(StringUtils.isEmpty(token)){
                jsonObject.put("success", false);
                jsonObject.put("msg","获取token失败");
                return jsonObject;
            }
            String passwordStr = UUID.randomUUID().toString().replaceAll("-","");
            boolean success =  dingTalkClient.send(passwordStr);
            if(success){
                password = new OnlinePassword();
                password.setAccessToken(token);
                password.setExpireDate(System.currentTimeMillis() + expireTime);
                password.setPassword(passwordStr);
                passwords.put(id, password);
                jsonObject.put("success",true);
                jsonObject.put("msg","密码发送成功，请查看钉钉群");
            }else{
                jsonObject.put("success", false);
                jsonObject.put("msg", "密码发送失败，请重新获取密码");
            }
        } else {
            jsonObject.put("success", false);
            jsonObject.put("msg","密码已生成，请查看钉钉群。密码有效期两个小时，请勿重复点击。");
        }
        return jsonObject;
    }

    @Override
    public boolean chenckPassword(Integer id, String password) {
        OnlinePassword onlinePassword = passwords.get(id);
        return null != password
                && null != onlinePassword
                && null != onlinePassword.getPassword()
                && DigestUtils.md5DigestAsHex(onlinePassword.getPassword().getBytes()).equals(password);
    }
}
