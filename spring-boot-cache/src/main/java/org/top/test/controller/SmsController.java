package org.top.test.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.top.test.exception.Result;
import org.top.test.service.SmsService;

/**
 * @author JXS 发送短信
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @Resource
    private SmsService service;

    @PostMapping("/send/{phone}")
    public Result sendMesg(@PathVariable String phone){
        service.sendSms(phone);
        return Result.ok();
    }

}
