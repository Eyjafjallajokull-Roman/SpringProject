package com.example.SpringProject.service;

import com.example.SpringProject.model.CustomUserDetails;
import com.example.SpringProject.model.User;
import com.example.SpringProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByName(s);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("No User with this name");
        }
        return new CustomUserDetails(user);
    }
}
