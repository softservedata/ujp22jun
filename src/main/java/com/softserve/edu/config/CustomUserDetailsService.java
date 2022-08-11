package com.softserve.edu.config;

import com.softserve.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.softserve.edu.model.User;
import com.softserve.edu.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    //private UserService userService;
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userService.findByLogin(username);
        User user = userRepository.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
    
}
