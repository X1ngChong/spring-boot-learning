package org.top.test.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String resource = request.getRequestURI();
        String params = request.getQueryString();
        LocalDateTime requestTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedRequestTime = requestTime.format(formatter);

        log.info("请求方法:{}",method);
        log.info("请求的目标资源:{}",resource);
        log.info("请求参数: {}",params);
        log.info("发起请求时间:{}",formattedRequestTime);
        return true;
    }
}