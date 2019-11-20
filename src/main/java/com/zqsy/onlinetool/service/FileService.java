package com.zqsy.onlinetool.service;

import com.zqsy.onlinetool.model.UploadFileInfo;
import com.zqsy.onlinetool.vo.UploadFileInfoVo;

import java.util.List;

public interface FileService {

    int create(UploadFileInfo uploadFileInfo);

    int delete(Integer id);

    UploadFileInfo selectByPrimaryKey (Integer id);

    List<UploadFileInfoVo> selectByAppIds(List<Integer> appIds);
}
