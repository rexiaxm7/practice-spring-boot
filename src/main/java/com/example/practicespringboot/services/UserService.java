package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
