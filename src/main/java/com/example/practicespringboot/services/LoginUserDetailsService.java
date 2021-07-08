package com.example.practicespringboot.services;

import com.example.practicespringboot.entities.UserEntity;
import com.example.practicespringboot.repositories.IUserRepository;
import com.example.practicespringboot.utils.LoginUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    final IUserRepository userRepository;

    public LoginUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        if(loginId == null || loginId.equals("")){
            throw new UsernameNotFoundException("");
        }

        UserEntity userEntity = userRepository.findByLoginId(loginId);

        return new LoginUserDetails(userEntity);
    }
}
