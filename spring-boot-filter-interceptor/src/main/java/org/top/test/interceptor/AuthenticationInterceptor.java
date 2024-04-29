package org.top.test.interceptor;

import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.top.test.constant.Constant;
import org.top.test.enums.ErrorCode;
import org.top.test.excepiton.ServerException;
import org.top.test.utils.JwtUtil;

/**
 * @author JXS
 */
@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(Constant.HEADER); // 获取 Authorization 头中的 token
        System.out.println(token);
        if (token != null && JwtUtil.validate(token)) { // 验证 token 的有效性
            log.info("token验证成功");
            String accessToken = JwtUtil.getAccessToken(request);
            JSONObject payload = JwtUtil.getPayload(accessToken);
            int userId = payload.getInt(Constant.USER_ID);
            String nickname = payload.getStr(Constant.NICKNAME);
            response.setHeader("userId", String.valueOf(userId));
            response.setHeader("nickname", nickname);
            return true; // 继续请求处理
        } else {
            throw new ServerException(ErrorCode.TOKEN_ERROR);
        }
    }
}