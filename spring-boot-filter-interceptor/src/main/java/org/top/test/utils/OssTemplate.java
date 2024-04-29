package org.top.test.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.top.test.config.OssConfig;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author mqxu
 * @description OssTemplate
 **/
@Component
public class OssTemplate {

    private static final String [] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};
    @Resource
    private OssConfig ossConfig;

    /**
     * 上传文件
     *
     * @param file 文件参数
     * @return 上传后的 url
     */

    public String ossUpload(MultipartFile file) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("image/jpg");

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
        // 上传文件存放的路径
        String uploadPath = dir + file.getOriginalFilename();
        // 获取文件的字节输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 调用 SDK 上传文件
        ossClient.putObject(bucket, uploadPath, inputStream,meta);
        // 关闭 ossClient
        ossClient.shutdown();
        // 返回上传文件的 url
        return host + "/" + uploadPath;
    }

    /**
     * 使用流上传
     * @param inputStream
     * @param originalFilename
     * @return
     */
    public String ossUpload2(InputStream inputStream,String originalFilename) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("image/jpg");
        meta.setContentDisposition("inline");

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
        // 上传文件存放的路径
        String uploadPath = dir + originalFilename;
        // 调用 SDK 上传文件
        ossClient.putObject(bucket, uploadPath, inputStream,meta);
        // 关闭 ossClient
        ossClient.shutdown();
        // 返回上传文件的 url
        return host + "/" + uploadPath;
    }

}