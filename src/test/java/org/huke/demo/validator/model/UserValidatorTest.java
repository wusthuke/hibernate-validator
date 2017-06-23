package org.huke.demo.validator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author huke
 * @create 22/6/2017
 */

public class UserValidatorTest {

    private static Validator validator;

    @Before
    public void before() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidate() {
        User user = new User();
        user.setUsername("huke");
        user.setPassword("123456");
        user.setPhone("12378966789");

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        constraintViolations.stream().forEach(p -> {
            System.out.println(p.getMessage());
        });

        Assert.assertEquals(1, constraintViolations.size());
    }
}
