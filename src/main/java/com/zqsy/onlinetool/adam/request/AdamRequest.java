package com.zqsy.onlinetool.adam.request;

import java.io.Serializable;

public class AdamRequest implements Serializable {

    private String httpToken;

    public String getHttpToken() {
        return httpToken;
    }

    public void setHttpToken(String httpToken) {
        this.httpToken = httpToken;
    }
}
