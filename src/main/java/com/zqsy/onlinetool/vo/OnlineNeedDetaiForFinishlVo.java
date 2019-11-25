package com.zqsy.onlinetool.vo;

import java.io.Serializable;
import java.util.List;

public class OnlineNeedDetaiForFinishlVo implements Serializable {

    private List<OnlineNeedDetailVo> onlineDetail;

    private List<OnlineFinishVo> finishDetail;

    public List<OnlineNeedDetailVo> getOnlineDetail() {
        return onlineDetail;
    }

    public void setOnlineDetail(List<OnlineNeedDetailVo> onlineDetail) {
        this.onlineDetail = onlineDetail;
    }

    public List<OnlineFinishVo> getFinishDetail() {
        return finishDetail;
    }

    public void setFinishDetail(List<OnlineFinishVo> finishDetail) {
        this.finishDetail = finishDetail;
    }
}
