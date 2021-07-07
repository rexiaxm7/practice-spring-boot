package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserCreateForm;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByIdAndEmail(Long id, String email) {
        return userRepository.findByIdAndEmail(id, email);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void createUser(UserCreateForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setName(userForm.getName());
        user.setGender(userForm.getGender());
        user.setLoginId(userForm.getLoginId());
        user.setPassword(userForm.getPassword());

        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User targetUser = userRepository.getById(id);

        targetUser.setEmail(user.getEmail());
        targetUser.setName(user.getName());
        targetUser.setGender(user.getGender());

        userRepository.save(targetUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
