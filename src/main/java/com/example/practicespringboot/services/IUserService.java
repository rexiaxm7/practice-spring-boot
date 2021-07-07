package com.example.practicespringboot.services;

import com.example.practicespringboot.domains.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findByEmail(String email);

    User findByIdAndEmail(Long id, String email);

    User getById(Long id);

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
