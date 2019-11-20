package com.zqsy.onlinetool.serviceimpl;

import com.zqsy.onlinetool.mapper.FileMapper;
import com.zqsy.onlinetool.model.UploadFileInfo;
import com.zqsy.onlinetool.service.FileService;
import com.zqsy.onlinetool.vo.UploadFileInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("uploadService")
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public int create(UploadFileInfo uploadFileInfo) {
        return this.fileMapper.insert(uploadFileInfo);
    }

    @Override
    public int delete(Integer id) {
        return this.fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UploadFileInfo selectByPrimaryKey(Integer id) {
        return this.fileMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UploadFileInfoVo> selectByAppIds(List<Integer> appIds) {
        return this.fileMapper.selectByAppIds(appIds);
    }
}
