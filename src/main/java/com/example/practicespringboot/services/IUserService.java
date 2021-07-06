package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User getById(Long id);

    User findByEmail(String email);

    User findByIdAndEmail(Long id, String email);

    UserEditForm getUserOnForm(Long id);

    void createUser(UserCreateForm userForm);

    void updateUser(Long id, UserEditForm userEditForm);

    void deleteUser(Long id);
}
