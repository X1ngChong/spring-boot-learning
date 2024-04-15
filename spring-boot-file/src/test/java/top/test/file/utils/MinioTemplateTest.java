package top.test.file.utils;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MinioTemplateTest {

    @Resource
    private MinioTemplate minioTemplate;
    @Test
    void bucketExists() throws Exception {
        boolean flag = minioTemplate.bucketExists("avatar");
        System.out.println(flag);
    }

    @Test
    void makeBucket() throws Exception {
       minioTemplate.makeBucket("hello");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:\\classdemo\\filedemo\\123.jpg");
        ObjectWriteResponse owr = minioTemplate.putObject("mqxu", "img/test.jpg", new FileInputStream(file));
        System.out.println(owr.object());
        System.out.println("http://43.137.12.232:9000/mqxu/"+owr.object());
    }
}