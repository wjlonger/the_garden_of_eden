package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.FileMapper;
import com.zqsy.onlinetool.model.UploadFileInfo;
import com.zqsy.onlinetool.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uploadService")
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public int create(UploadFileInfo uploadFileInfo) {
        return fileMapper.insert(uploadFileInfo);
    }

    @Override
    public int delete(Integer id) {
        return fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UploadFileInfo selectByPrimaryKey(Integer id) {
        return fileMapper.selectByPrimaryKey(id);
    }
}
