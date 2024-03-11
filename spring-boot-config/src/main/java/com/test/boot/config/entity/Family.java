package com.test.boot.config.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author JXS
 */
@Data
@Component
@Validated
//@ConfigurationProperties(prefix = "family")//整体前缀 sufix后缀
@PropertySource(value = {"classpath:family.properties"})//加载外部配置文件
public class Family {

//    @Value("${family.family-name}")
    private String familyName;

//    @Value("${family.father}")
    @Length(min=6,max = 20,message = "父亲名字必须是6-20位之间")
    private String father;

//    @Value("${family.mother}")
    private String mother;

//    @Value("${family.child}")
    private String child;

    @Range(min=5,message = "家庭年限最少5年")
    private Integer years;

}
