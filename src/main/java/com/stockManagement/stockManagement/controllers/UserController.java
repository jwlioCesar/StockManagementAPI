package com.stockManagement.stockManagement.controllers;

import com.stockManagement.stockManagement.dto.request.UserRegisterRequestDto;
import com.stockManagement.stockManagement.entities.User;
import com.stockManagement.stockManagement.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
       return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterRequestDto request){
        return ResponseEntity.ok().body(userService.register(request));
    }
}
