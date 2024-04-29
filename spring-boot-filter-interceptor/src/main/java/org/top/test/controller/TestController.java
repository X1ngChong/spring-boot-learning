package org.top.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hello";
    }
}
