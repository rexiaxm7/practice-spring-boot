package com.example.practicespringboot.validations;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.services.IUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnusedValidator implements ConstraintValidator<EmailUnused, String> {
    private final IUserService IUserService;

    public EmailUnusedValidator(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    public void initialize(EmailUnused constraintAnnotation) { }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        User user = IUserService.findByEmail(email);

        return user == null;
    }

}
