package com.example.practicespringboot.utils;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserEditForm;

public class UserConverter {

    public static UserEditForm ToEditForm(User user) {

        UserEditForm userEditForm = new UserEditForm();
        userEditForm.setEmail(user.getEmail());
        userEditForm.setName(user.getName());
        userEditForm.setGender(user.getGender());
        return userEditForm;
    }

    public static User ToUser(UserEditForm userEditForm) {

        User user = new User();
        user.setEmail(userEditForm.getEmail());
        user.setName(userEditForm.getName());
        user.setGender(userEditForm.getGender());
        return user;
    }

}
