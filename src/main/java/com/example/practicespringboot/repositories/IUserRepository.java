package com.example.practicespringboot.repositories;

import com.example.practicespringboot.domains.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    User getById(Long id);

    User findByEmail(String email);

    User findByIdAndEmail(Long id, String email);

    void deleteById(Long id);

    void updateById(Long id, User user);

    void save(User user);
}
