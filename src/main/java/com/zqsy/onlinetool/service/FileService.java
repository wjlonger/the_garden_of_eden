package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.UploadFileInfo;

public interface FileService {

    int create(UploadFileInfo uploadFileInfo);

    int delete(Integer id);

    UploadFileInfo selectByPrimaryKey (Integer id);

}
