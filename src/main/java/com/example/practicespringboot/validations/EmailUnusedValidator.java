package com.example.practicespringboot.validations;

import com.example.practicespringboot.domains.User;
import com.example.practicespringboot.services.IUserService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnusedValidator implements ConstraintValidator<EmailUnused, Object> {
    private final IUserService userService;

    public EmailUnusedValidator(IUserService userService) {
        this.userService = userService;
    }

    public void initialize(EmailUnused constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);

        Long id = beanWrapper.isReadableProperty("id")
                ? (Long) beanWrapper.getPropertyValue("id")
                : null;

        String email = (String) beanWrapper.getPropertyValue("email");

        User user = userService.findByEmail(email);

        if(id == null){
            return user == null;
        } else {
            if (email != null && email.equals("")) return true;

            if(user == null){
                return true;
            }else{
                User editUser = userService.findByIdAndEmail(id, email);
                return editUser != null;
            }
        }

    }

}
