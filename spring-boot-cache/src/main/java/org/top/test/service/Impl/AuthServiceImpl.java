package org.top.test.service.Impl;

import io.netty.util.internal.ObjectUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.top.test.config.RedisCache;
import org.top.test.exception.ErrorCode;
import org.top.test.exception.ServerException;
import org.top.test.redisKeys.RedisKeys;
import org.top.test.service.AuthService;

import java.util.UUID;

/**
 * @author JXS
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private RedisCache redisCache;

    @Override
    public String loginByPhone(String phone, String code) {
      String smsCacheKey =   RedisKeys.getSmsKey(phone);
        Integer resultCode =(Integer) redisCache.get(smsCacheKey);

        if(ObjectUtils.isEmpty(resultCode) || !resultCode.toString().equals(code)){
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }

        redisCache.delete(smsCacheKey);
        //返回一个token
        return UUID.randomUUID().toString();
    }
}
