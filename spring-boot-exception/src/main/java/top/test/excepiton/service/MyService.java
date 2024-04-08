package top.test.excepiton.service;

import org.springframework.stereotype.Service;
import top.test.excepiton.enums.ErrorCode;
import top.test.excepiton.excepiton.ServerException;

@Service
public class MyService {

    /**
     * 未登录异常
     */
    public void unAuthorizedError(){
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }

    /**
     * 模拟系统异常
     */
    public void serverError(){
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
