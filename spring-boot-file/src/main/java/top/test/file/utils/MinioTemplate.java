package top.test.file.utils;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Configuration
public class MinioTemplate {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.sercretKey}")
    private String sercretKey;

    private MinioClient client;

    @PostConstruct//方法执行时机
    public void init(){
        client = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey,sercretKey)
                .build();

    }

    /**
     * 判断bucket是否存在
     */
    public boolean bucketExists(String bucketName) throws Exception{
        return client.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build());
    }

    public  void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if(!flag){
            client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /*
    上传文件
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception{
    return client.putObject(
            PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(inputStream,-1,1048784784).build()
    );
    }


}
