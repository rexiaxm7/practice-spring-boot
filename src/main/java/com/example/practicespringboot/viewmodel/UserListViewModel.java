package com.example.practicespringboot.viewmodel;

import com.example.practicespringboot.entity.User;

import java.util.List;

public class UserListViewModel {
    public UserListViewModel(List<User> users){
        this.users = users;
    }

    public List<User> users;
}
