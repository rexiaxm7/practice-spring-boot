package com.example.practicespringboot.viewmodel;

import com.example.practicespringboot.entity.User;

import java.util.List;
import java.util.Objects;

public class UserListViewModel {
    public UserListViewModel(List<User> users){
        this.users = users;
    }

    public final List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListViewModel that = (UserListViewModel) o;
        return users.equals(that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
