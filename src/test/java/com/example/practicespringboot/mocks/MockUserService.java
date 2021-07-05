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
    public User getById(Long id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public UserForm getUserOnForm(Long id) {
        return null;
    }

    @Override
    public void createUser(UserForm userForm) {

    }

    @Override
    public void updateUser(Long id, UserForm userForm) {

    }

    @Override
    public void deleteUser(Long id) {

    }

}
