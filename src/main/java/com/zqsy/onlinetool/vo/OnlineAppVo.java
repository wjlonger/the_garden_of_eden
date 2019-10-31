package com.zqsy.onlinetool.vo;

import com.zqsy.onlinetool.model.UploadFileInfo;

import java.io.Serializable;
import java.util.List;

public class OnlineAppVo implements Serializable {

    private Integer id;

    private String name;

    private String phone;

    private String email;

    private Long date;

    private Integer time;

    private String version;

    private List<OnlineNeedVo> needList;

    private List<UploadFileInfo> fileList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<OnlineNeedVo> getNeedList() {
        return needList;
    }

    public void setNeedList(List<OnlineNeedVo> needList) {
        this.needList = needList;
    }

    public List<UploadFileInfo> getFileList() {
        return fileList;
    }

    public void setFileList(List<UploadFileInfo> fileList) {
        this.fileList = fileList;
    }
}