package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.dto.request.UserRegisterRequestDto;
import com.stockManagement.stockManagement.dto.response.UserRegisterResponseDto;
import com.stockManagement.stockManagement.entities.User;
import com.stockManagement.stockManagement.enums.RoleName;
import com.stockManagement.stockManagement.exceptions.UserNotFoundException;
import com.stockManagement.stockManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder encoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto request)throws UserNotFoundException {
        if (request.email() != null || request.email() == userRepository.findByEmail(request.email()).getUsername()){
            throw new UserNotFoundException();
        }
        User user = new User(request.email(), request.name(), request.password());
//        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnable(true);
        user.setRoles(new ArrayList<>(RoleName.ROLE_USER.ordinal()));
        userRepository.save(user);
        return new UserRegisterResponseDto(user.getName(), user.getEmail());
    }

}
