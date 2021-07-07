package com.example.practicespringboot.repositories;

import com.example.practicespringboot.domains.User;
import com.example.practicespringboot.entities.UserEntity;
import com.example.practicespringboot.utils.UserConverter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    private final IBaseUserRepository baseUserRepository;

    public UserRepository(IBaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = baseUserRepository.findAll();
        return userEntities.stream()
                .map(UserConverter::ToUser)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(Long id) {
        Optional<UserEntity> userEntity = baseUserRepository.findById(id);
        return UserConverter.ToUser(userEntity.get());
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = baseUserRepository.findByEmail(email);
        return UserConverter.ToUser(userEntity);
    }

    @Override
    public User findByIdAndEmail(Long id, String email) {
        UserEntity userEntity = baseUserRepository.findByIdAndEmail(id, email);
        return UserConverter.ToUser(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        baseUserRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, User user){
        UserEntity userEntity = baseUserRepository.getById(id);

        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setGender(user.getGender());

        baseUserRepository.save(userEntity);
    }

    @Override
    public void save(User user) {
        baseUserRepository.save(UserConverter.ToEntity(user));
    }


}
