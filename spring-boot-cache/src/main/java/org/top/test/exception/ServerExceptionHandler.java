package org.top.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author JXS
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = ServerException.class)
    public Result <?> handleServerException(ServerException e){
        return Result.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> handleException(Exception e){
        return Result.error(e.getMessage());
    }
}
