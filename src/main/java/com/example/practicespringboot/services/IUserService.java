package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserForm;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void saveUser(UserForm userForm);

    void deleteUser(Long id);
}
