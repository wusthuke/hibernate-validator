package org.huke.demo.validator.model;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author huke
 * @create 22/6/2017
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 手机号为空不验证，配合 @NotNull 使用
        if (! StringUtils.hasLength(value)) return true;

        if (value.length() != 11) {
            context.disableDefaultConstraintViolation();//禁用默认的message的值
            //重新添加错误提示语句
            context.buildConstraintViolationWithTemplate("手机号长度非法").addConstraintViolation();
            return false;
        }

        if (! value.startsWith("136")) {
            context.disableDefaultConstraintViolation();//禁用默认的message的值
            context.buildConstraintViolationWithTemplate("手机号段非法").addConstraintViolation();
            return false;
        }
        return false;
    }
}
