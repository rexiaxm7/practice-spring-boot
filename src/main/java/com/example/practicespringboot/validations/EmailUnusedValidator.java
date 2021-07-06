package com.example.practicespringboot.validations;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;
import com.example.practicespringboot.services.IUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnusedValidator implements ConstraintValidator<EmailUnused, Object> {
    private final IUserService userService;
    private UserCreateForm userCreateForm = new UserCreateForm();
    private UserEditForm userEditForm = new UserEditForm();

    public EmailUnusedValidator(IUserService userService) {
        this.userService = userService;
    }

    public void initialize(EmailUnused constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user;

        if(value.getClass().equals(userCreateForm.getClass())){
            UserCreateForm createUserForm = (UserCreateForm) value;

            user = userService.findByEmail(createUserForm.getEmail());
            return user == null;
        }

        if(value.getClass().equals(userEditForm.getClass())){
            UserEditForm userEditForm = (UserEditForm) value;

            if(userEditForm.getEmail().equals("")) return true;

            user = userService.findByIdAndEmail(userEditForm.getId(), userEditForm.getEmail());
            return user != null;
        }

        return true;
    }

}
