package com.zqsy.onlinetool.vo;

import java.io.Serializable;

public class OnlineNeedDetailVo implements Serializable {

    private Integer id;

    private String projectName;

    private String projectBranch;

    private String userName;

    private Boolean newProject;

    private String lastVersion;

    private Byte type;

    private Integer needId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectBranch() {
        return projectBranch;
    }

    public void setProjectBranch(String projectBranch) {
        this.projectBranch = projectBranch == null ? null : projectBranch.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Boolean getNewProject() {
        return newProject;
    }

    public void setNewProject(Boolean newProject) {
        this.newProject = newProject;
    }

    public String getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }
}