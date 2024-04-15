package top.test.file.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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


        return request.getScheme() + "//" + request.getServerName() + ":" + request.getServerPort() + "/" + today + "/" + newFileName;
    }
}
