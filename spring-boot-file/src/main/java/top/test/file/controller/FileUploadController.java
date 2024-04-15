package top.test.file.controller;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.test.file.utils.MinioTemplate;
import top.test.file.utils.OssTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @author JXS
 */
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {
    @Value("${file.upload-path}")
    private String uploadPath;

    @Resource
    private MinioTemplate minioTemplate;

    @Resource
    private OssTemplate ossTemplate;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    @PostMapping("/native")
    public String nativeUpload(MultipartFile file, HttpServletRequest request){
        String today = df.format(new Date());

        File folder = new File(uploadPath + "/");
        if (!folder.exists()){
            boolean flag = folder.mkdir();
            System.out.println(flag);
        }

        String oldFileName = file.getOriginalFilename();
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index+1);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() +"."+ suffixName;
        System.out.println(newFileName);
        //todo:
        try {
            file.transferTo(new File(folder,newFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + today + "/" + newFileName;
    }


    @PostMapping("/minio")
    public String minioUpload(MultipartFile file, HttpServletRequest request) {
        String bucketName = "bhui";
        ObjectWriteResponse owr = null;
        try (InputStream inputStream = file.getInputStream()) { // 获取 MultipartFile 的输入流
            owr = minioTemplate.putObject(bucketName, "img/test01.jpg", inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(owr.object());
        System.out.println("http://43.137.12.232:9000/" + bucketName + "/" + owr.object());
        // 拼接可访问的地址
        return "http://43.137.12.232:9000/" + bucketName + "/" + owr.object();
    }

    /**
     * oss 文件上传
     * @param file 文件对象
     * @return 文件上传后的地址
     */
    @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }
}
