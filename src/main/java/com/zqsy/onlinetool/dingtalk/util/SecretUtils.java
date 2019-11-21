package com.zqsy.onlinetool.dingtalk.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SecretUtils {

    private SecretUtils () {}

    public static String encrypt(long timestamp, String secret){
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal((timestamp + "\n" + secret).getBytes("UTF-8"));
            return URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        } catch (NoSuchAlgorithmException |InvalidKeyException | UnsupportedEncodingException e) {
        }
        return "";
    }

}
