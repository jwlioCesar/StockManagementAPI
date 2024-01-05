package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

}
