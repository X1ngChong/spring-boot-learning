package org.top.test.redisKeys;

public class RedisKeys {
    public static String getSmsKey(String phone){
        return "sms:captcha:"+phone;
    }
}
