package com.example.practicespringboot.repositories;

import com.example.practicespringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByIdAndEmail(Long id, String email);
}
