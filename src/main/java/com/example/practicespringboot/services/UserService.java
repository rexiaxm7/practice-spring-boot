package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;
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
    public User getById(Long id) {
        return userRepository.getById(id);
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
    public UserEditForm getUserOnForm(Long id) {
        User user = userRepository.getById(id);

        // 編集対象のユーザー情報をUserFormにセットする
        UserEditForm userForm = new UserEditForm();

        userForm.setEmail(user.getEmail());
        userForm.setName(user.getName());
        userForm.setGender(user.getGender());

        return userForm;
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
    public void updateUser(Long id, UserEditForm userEditForm) {
        User user = userRepository.getById(id);

        user.setEmail(userEditForm.getEmail());
        user.setName(userEditForm.getName());
        user.setGender(userEditForm.getGender());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
