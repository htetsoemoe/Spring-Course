package com.example.demosecuritysalt.validation;

import com.example.demosecuritysalt.ds.RegisteringUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisteringUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisteringUser registeringUser = (RegisteringUser) target;

        if (!registeringUser.getPassword().equals(registeringUser.getRepeatedPassword())) {
            errors.rejectValue("password", null, "Password and Repeated password needs to match!");
        }
    }
}
