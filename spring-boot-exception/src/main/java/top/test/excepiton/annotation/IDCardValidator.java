package top.test.excepiton.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author JXS
 */
public class IDCardValidator implements ConstraintValidator<IDCard,String> {

    //手机号正则表达式
    private static final String REGEX_IDCARD = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}([0-9]|X)$";
    @Override
    public void initialize(IDCard idCard) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       if(StringUtils.isBlank(value)){
           return true;
       }
       return Pattern.matches(REGEX_IDCARD,value);
    }
}
