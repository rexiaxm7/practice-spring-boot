package com.example.practicespringboot.utils;

import com.example.practicespringboot.entities.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class LoginUserDetails extends User {
    public LoginUserDetails(UserEntity userEntity){
        super(userEntity.getLoginId(), userEntity.getPassword(), Collections.emptySet());
    }
}
