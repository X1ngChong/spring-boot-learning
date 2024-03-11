package com.test.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {
    @Resource
    Employee employee;

    @Test
    void testEM (){
//        employee.getEmployeeName().forEach(System.out::println);
//
//        System.out.println(employee.getFirstName());

        System.out.println(employee.getFirstAge());
    }

}