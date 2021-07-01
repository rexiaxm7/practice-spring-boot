package com.example.practicespringboot.controller;

import com.example.practicespringboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.practicespringboot.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/get")
    public List<User> get(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
