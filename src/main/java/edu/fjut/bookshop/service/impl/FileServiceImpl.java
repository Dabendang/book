package edu.fjut.bookshop.service.impl;

import edu.fjut.bookshop.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements IFileService {
    @Override
    public String upload(MultipartFile file, String path) {

        String originalFilename = file.getOriginalFilename();
        String extensionName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        String uploadFileName= UUID.randomUUID().toString().replaceAll("-","")+"."+extensionName;
        log.info("开始上传文件,上传的文件名:{},上传的路径:{},新文件名:{}",originalFilename,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            log.error("上传文件异常",e);
        }

        return targetFile.getName();
    }
}
