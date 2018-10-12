package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import com.mmall.vo.ProductDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.UUID;


/**
 * @author admin
 * @date 2018/8/1 14:17
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload (MultipartFile file,String path){
        String fileName = file.getOriginalFilename(); //拿到上传文件的原始文件名
        //获得扩展名例如abc.jpg
        //得到的就是jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{}，上传的路径：{},新文件名：{}",fileName,path,uploadFileName);
        //通过"{}"进行占位,注意一一对应

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try{
            file.transferTo(targetFile);
            //文件已经上传成功了


            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上了

            //上传之后删除upload下面的文件
            targetFile.delete();
        }catch (IOException e){
            logger.info("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }



}
