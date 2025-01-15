package com.example.spring_personal_finance_tracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_personal_finance_tracker.dto.LoginRequest;
import com.example.spring_personal_finance_tracker.dto.LoginResponse;
import com.example.spring_personal_finance_tracker.model.User;
import com.example.spring_personal_finance_tracker.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService; 

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByUsername(loginRequest.getUsername()); 

        if(user != null && user.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok().body(new LoginResponse("Login successful"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
