package org.top.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Tag(name = "测试接口")
public class TestController {

    @GetMapping("/test")
    @Operation(summary = "测试接口")
    public String test(){
        return "1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hello";
    }
}
