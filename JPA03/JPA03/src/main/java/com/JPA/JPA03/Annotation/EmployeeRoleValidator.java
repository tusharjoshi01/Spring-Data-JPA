package com.JPA.JPA03.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;
import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

List<String> roles = List.of("ADMIN","USER");
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
       return roles.contains(inputRole);
    }
}
