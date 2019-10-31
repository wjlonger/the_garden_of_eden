package com.zqsy.onlinetool.controller;

import com.alibaba.fastjson.JSONObject;
import com.zqsy.onlinetool.model.UploadFileInfo;
import com.zqsy.onlinetool.service.FileService;
import com.zqsy.onlinetool.utils.StreamUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private JSONObject jsonObject;

    @Autowired
    private FileService fileService;

    @Value("${upload.filepath}")
    private String filePath;

    @PostMapping("/{appId}")
    public JSONObject singleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable("appId") Integer appId) {
        String date = LocalDate.now().toString();
        File folder = new File(filePath + date);
        if(!folder.exists() && !folder.isDirectory()){
            folder.mkdir();
        }
        String fileName = file.getOriginalFilename();
        int dotIndex = fileName.lastIndexOf(".");
        String suffixName = dotIndex > 0 ? fileName.substring(dotIndex) : "";
        String newFileName = UUID.randomUUID().toString() + suffixName;
        String fullName = folder.getAbsolutePath() + File.separator + newFileName;
        try {
            file.transferTo(new File(fullName));
            UploadFileInfo uploadFileInfo = new UploadFileInfo();
            uploadFileInfo.setAppId(appId);
            uploadFileInfo.setOriginName(fileName);
            uploadFileInfo.setTargetName(fullName);
            uploadFileInfo.setUploadTime(System.currentTimeMillis());
            fileService.create(uploadFileInfo);
            jsonObject.put("success", true);
            jsonObject.put("data", uploadFileInfo);
        } catch (IOException e) {
            jsonObject.put("success", false);
        } finally {
            return jsonObject;
        }
    }

    @GetMapping("/{id}")
    public void downLoad (@PathVariable("id") Integer id, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            hasFile : {
                UploadFileInfo uploadFileInfo = fileService.selectByPrimaryKey(id);
                if(null == uploadFileInfo || StringUtils.isEmpty(uploadFileInfo.getTargetName())){
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    outputStream = response.getOutputStream();
                    outputStream.write("{msg:\"文件不存在或被移除\"}".getBytes());
                    break hasFile;
                }
                response.setContentType("application/force-download");
                response.addHeader("Content-disposition", "attachment;filename=" + uploadFileInfo.getOriginName());
                inputStream = new FileInputStream(uploadFileInfo.getTargetName());
                outputStream = response.getOutputStream();
                outputStream.write(StreamUtils.toByteArray(inputStream));
            }
            outputStream.flush();
        } catch (IOException e) {
        }finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if(null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") Integer id) {
        UploadFileInfo uploadFileInfo = fileService.selectByPrimaryKey(id);
        if(null != uploadFileInfo && !StringUtils.isEmpty(uploadFileInfo.getTargetName())){
            File file = new File(uploadFileInfo.getTargetName());
            if (file.exists() && file.isFile()){
                file.delete();
            }
            fileService.delete(id);
        }
    }
}
