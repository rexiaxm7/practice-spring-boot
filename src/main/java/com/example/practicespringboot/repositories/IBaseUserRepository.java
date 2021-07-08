package com.example.practicespringboot.repositories;

import com.example.practicespringboot.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByLoginId(String loginId);
    UserEntity findByIdAndEmail(Long id, String email);
}
