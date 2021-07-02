package com.example.practicespringboot.service;

import com.example.practicespringboot.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
