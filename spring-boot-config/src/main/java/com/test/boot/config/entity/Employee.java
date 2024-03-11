package com.test.boot.config.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author JXS
 */
@Data
@Component
@PropertySource(value = {"classpath:employee.properties"})//加载外部配置文件
public class Employee {

    /**
     * 使用 SpEl读取 employee 的names属性,并分割字符串集合
     */
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeName;


    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstName;

    @Value("#{${employee.ages}}")
    private Map<String,Integer> employeeAge;

    @Value("#{${employee.ages}.one}")
    private Integer firstAge;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;

}
