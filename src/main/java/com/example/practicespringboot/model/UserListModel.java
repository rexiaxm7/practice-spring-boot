package com.example.practicespringboot.model;

import com.example.practicespringboot.entity.User;

import java.util.List;

public class UserListModel {
    public UserListModel(List<User> users){
        this.users = users;
    }

    public List<User> users;
}
