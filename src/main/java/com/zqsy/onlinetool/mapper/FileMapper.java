package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.UploadFileInfo;

public interface FileMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UploadFileInfo record);

    int insertSelective(UploadFileInfo record);

    UploadFileInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadFileInfo record);

    int updateByPrimaryKey(UploadFileInfo record);
}