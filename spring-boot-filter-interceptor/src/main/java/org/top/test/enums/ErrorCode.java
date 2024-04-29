package org.top.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author JXS
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNAUTHORIZED(401,"登录失效,请重新登录"),
    INTERNAL_SERVER_ERROR(500,"服务器异常,请重试"),
    TOKEN_ERROR(403,"token失效"),
    JWT_CHECK_ERROR(405,"jwt校验异常"),
    IMAGE_ERROR(406,"文件上传异常"),
    UNKNOWN_ERROR(999,"未知错误");

    private final int code;
    private final String msg;

}
