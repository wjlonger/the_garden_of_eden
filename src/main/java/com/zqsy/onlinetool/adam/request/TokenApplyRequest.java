package com.zqsy.onlinetool.adam.request;

import java.io.Serializable;

public class TokenApplyRequest extends AdamRequest implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
