package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserForm;
import com.example.practicespringboot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public void saveUser(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setName(userForm.getName());
        user.setLoginId(userForm.getLoginId());
        user.setGender(userForm.getGender());
        user.setPassword(userForm.getPassword());

        userRepository.save(user);
    }

}
