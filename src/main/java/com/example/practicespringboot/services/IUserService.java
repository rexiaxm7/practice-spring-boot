package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserForm;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User getById(Long id);

    void createUser(UserForm userForm);

    void updateUser(Long id, UserForm userForm);

    void deleteUser(Long id);
}
