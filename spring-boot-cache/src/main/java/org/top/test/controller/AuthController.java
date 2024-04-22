package org.top.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.test.entity.UserDto;
import org.top.test.exception.Result;
import org.top.test.service.AuthService;


/**
 * @author JXS 登录验证
 */
@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto){
        String token = authService.loginByPhone(userDto.getPhone(),userDto.getCode());//如果成功就会返回一个token,如果失败了全局异常统一处理

        return Result.ok(token);
    }
}
