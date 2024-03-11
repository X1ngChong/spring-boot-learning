package com.test.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersonTest {

    @Resource
    private Dog dog;

    @Resource
    private Person person;

    @Test
    void testPerson(){
        System.out.println(dog);
        System.out.println(person);
    }
}