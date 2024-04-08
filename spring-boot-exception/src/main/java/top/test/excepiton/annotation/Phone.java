package top.test.excepiton.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JXS 自定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
    String message() default "手机号格式不正确";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
