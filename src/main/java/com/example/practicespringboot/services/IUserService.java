package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
