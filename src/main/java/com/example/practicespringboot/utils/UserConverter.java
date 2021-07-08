package com.example.practicespringboot.utils;

import com.example.practicespringboot.domains.User;
import com.example.practicespringboot.entities.UserEntity;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;
import com.example.practicespringboot.forms.UserListForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    private final PasswordEncoder passwordEncoder;

    public UserConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserListForm ToListForm(List<User> users) {

        List<UserListForm.UserForm> userForms = users.stream()
                .map(user -> {
                    UserListForm.UserForm userForm = new UserListForm.UserForm();
                    userForm.setId(user.getId());
                    userForm.setEmail(user.getEmail());
                    userForm.setGender(user.getGender());
                    userForm.setLoginId(user.getLoginId());
                    userForm.setName(user.getName());
                    return userForm;
                })
                .collect(Collectors.toList());
        return new UserListForm(userForms);
    }

    public UserEditForm ToEditForm(User user) {

        UserEditForm userEditForm = new UserEditForm();
        userEditForm.setEmail(user.getEmail());
        userEditForm.setName(user.getName());
        userEditForm.setGender(user.getGender());
        return userEditForm;
    }

    public UserEntity ToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setGender(user.getGender());
        userEntity.setLoginId(user.getLoginId());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }

    public User ToUser(UserCreateForm userCreateForm) {
        User user = new User();
        user.setEmail(userCreateForm.getEmail());
        user.setName(userCreateForm.getName());
        user.setGender(userCreateForm.getGender());
        user.setLoginId(userCreateForm.getLoginId());
        String encodePassword = passwordEncoder.encode(userCreateForm.getPassword());
        user.setPassword(encodePassword);
        return user;
    }

    public User ToUser(UserEditForm userEditForm) {

        User user = new User();
        user.setEmail(userEditForm.getEmail());
        user.setName(userEditForm.getName());
        user.setGender(userEditForm.getGender());
        return user;
    }

    public User ToUser(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setName(userEntity.getName());
        user.setGender(userEntity.getGender());
        return user;
    }

}
