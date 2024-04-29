package org.top.test.controller;



import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.top.test.result.Result;

/**
 * @author JXS
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/info")
    public String getUserInfo(HttpServletResponse response) {
        String userId = response.getHeader("userId");
        String nickname = response.getHeader("nickname");
            return "User ID: " + userId + ", Nickname: " + nickname;
        }

    /**
     * oss 文件上传
     * @param file 文件对象
     * @return 文件上传后的地址
     */
    @PostMapping("/oss")
    public Result ossUpload(MultipartFile file) {
        return Result.ok();
        }
    }
