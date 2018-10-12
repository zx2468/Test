package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author admin
 * @date 2018/8/1 14:17
 */
public interface IFileService {

    String upload (MultipartFile file, String path);
}
