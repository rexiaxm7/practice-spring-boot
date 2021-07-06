package com.example.practicespringboot.validations;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.services.IUserService;
import org.springframework.beans.BeanUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnusedValidator implements ConstraintValidator<EmailUnused, Object> {
    private final IUserService IUserService;

    public EmailUnusedValidator(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    public void initialize(EmailUnused constraintAnnotation) { }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user;

        EmailCheck emailCheck = new EmailCheck();
        BeanUtils.copyProperties(value, emailCheck);

        if(emailCheck.getId() == null){
            user = IUserService.findByEmail(emailCheck.getEmail());
            return user == null;
        }else{
            if(emailCheck.getEmail().equals("")) return true;

            user = IUserService.findByIdAndEmail(emailCheck.getId(),emailCheck.getEmail());
            return user != null;
        }

    }

}
