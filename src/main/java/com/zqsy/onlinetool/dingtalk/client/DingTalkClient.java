package com.zqsy.onlinetool.dingtalk.client;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static com.zqsy.onlinetool.dingtalk.util.SecretUtils.encrypt;

@Configuration
public class DingTalkClient {

    @Value("${dingtalk.accesstoken}")
    private String accesstoken;

    @Value("${dingtalk.secret}")
    private String secret;

    public boolean send(String msg){
        Long timestamp = System.currentTimeMillis();
        com.dingtalk.api.DingTalkClient client = new DefaultDingTalkClient(accesstoken + "&timestamp=" + timestamp + "&sign=" + encrypt(timestamp, secret));
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(msg);
        request.setText(text);
        try {
            client.execute(request);
            return true;
        } catch (ApiException e) {
        }
        return false;
    }

}
