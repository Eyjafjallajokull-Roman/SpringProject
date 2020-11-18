package com.example.SpringProject.repository;


import com.example.SpringProject.model.CustomUserDetails;
import com.example.SpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private UserRepository repository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        User user = repository.findByUsername(username);

        if (Objects.isNull(user))
        {
            throw new UsernameNotFoundException("No user with username " + username);
        } else
        {
            return new CustomUserDetails(user);
        }
    }
}
