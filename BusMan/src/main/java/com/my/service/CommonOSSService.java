package com.my.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Author: Don
 * 测试文件上传
 */
public interface CommonOSSService {
    /**
     * 上传文件至阿里云 oss
     *
     * @param file 上传的源文件
     * @return 返回值ossFileUrlBoot oss地址  oldFileName 源文件名称
     * @throws Exception
     */
    Map uploadOSS(MultipartFile file) throws Exception;
}
