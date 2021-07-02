package com.example.practicespringboot.mocks;

import com.example.practicespringboot.entity.User;
import com.example.practicespringboot.service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class MockUserService implements IUserService {

    private final ArrayList<User> users;

    public MockUserService(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
