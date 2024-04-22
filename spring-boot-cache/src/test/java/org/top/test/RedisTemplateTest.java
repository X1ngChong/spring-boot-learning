package org.top.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void StringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("hello","world",60, TimeUnit.SECONDS);
    }
}
