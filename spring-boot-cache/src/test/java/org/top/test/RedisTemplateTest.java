package org.top.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.top.test.entity.Address;
import org.top.test.entity.User;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Test
    void StringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("hello","world",60, TimeUnit.SECONDS);
    }
    @Test
    void redisTemplate() {
        Address address = Address.builder().location("jiangsu").name("nihao").build();
        User user = User.builder().id(12).name("zangsan").address(address).build();
        redisTemplate.opsForValue().set("user",user,60, TimeUnit.SECONDS);
    }
}
