package com.zqsy.onlinetool.adam.request;

import java.io.Serializable;
import java.util.HashMap;

public class TaskBuildAdamRequest extends AdamRequest implements Serializable {

    private String token;

    private String region;

    private String taskName;

    private HashMap<String, Object> params;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }
}
