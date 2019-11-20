package com.zqsy.onlinetool.mapper;

import com.zqsy.onlinetool.model.UploadFileInfo;
import com.zqsy.onlinetool.vo.UploadFileInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UploadFileInfo record);

    int insertSelective(UploadFileInfo record);

    UploadFileInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadFileInfo record);

    int updateByPrimaryKey(UploadFileInfo record);

    List<UploadFileInfoVo> selectByAppIds(@Param("appIds") List<Integer> appIds);
}
