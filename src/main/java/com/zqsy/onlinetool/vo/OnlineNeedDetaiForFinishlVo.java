package com.zqsy.onlinetool.vo;

import java.io.Serializable;

public class OnlineNeedDetaiForFinishlVo extends OnlineNeedDetailVo implements Serializable {

    private OnlineFinishVo onlineFinishVo;

    public OnlineFinishVo getOnlineFinishVo() {
        return onlineFinishVo;
    }

    public void setOnlineFinishVo(OnlineFinishVo onlineFinishVo) {
        this.onlineFinishVo = onlineFinishVo;
    }
}
