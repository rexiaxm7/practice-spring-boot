package com.example.practicespringboot.mocks;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserForm;
import com.example.practicespringboot.services.IUserService;

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

    @Override
    public void saveUser(UserForm userForm) {

    }

}
