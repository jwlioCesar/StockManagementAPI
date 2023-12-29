package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.entities.User;
import com.stockManagement.stockManagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
