package com.example.spring_personal_finance_tracker.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_personal_finance_tracker.model.User;
import com.example.spring_personal_finance_tracker.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository; 
    private final PasswordEncoder passwordEncoder; 

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository; 
        this.passwordEncoder = passwordEncoder; 
    }

    // GET ALL USERS 
    public List<User> getAllUsers() {
        return userRepository.findAll(); 
    }

    // GET ONE USER BY ID 
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId); 
    }

    // GET ONE USER BY USERNAME 
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username); 
    }

    // ADD A USER 
    public void registerNewUser(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername()); 

        if(userOptional.isPresent()) {
            System.out.println("The username is taken");
            throw new IllegalStateException("Username \"" + user.getUsername() + "\" is already taken"); 
        }
        
        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user); 
    }

    // REMOVE A USER 
    public void deleteUser(long userId) {
        Optional<User> userOptional = userRepository.findById(userId); 

        if(!userOptional.isPresent()) {
            System.out.println("The user does not exist"); 
            throw new IllegalStateException("The user with user ID" + userId + " does not exist"); 
        }

        userRepository.deleteById(userId);
    }

    // UPDATE A USER 
    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String username, String role, String password) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(username + " does not exist"));

        // Dealing with firstName
        if(firstName != null && firstName.length() > 0 && !Objects.equals(firstName, user)) {
            user.setFirstName(firstName); 
        }

        // Dealing with lastName
        if(lastName != null && lastName.length() > 0 && !Objects.equals(lastName, user)) {
            user.setLastName(lastName); 
        }

        // Dealing with username
        if(username != null && username.length() > 0 && !Objects.equals(username, user)) {
            Optional<User> userOptional = userRepository.findByUsername(username); 

            if(userOptional.isPresent()) {
                System.out.println("The username is taken");
                throw new IllegalStateException("Username \"" + username + "\" is already taken"); 
            }

            user.setUsername(username); 
        }

        // Dealing with role
        if(role != null && role.length() > 0 && !Objects.equals(role, user)) {
            user.setRole(role); 
        }

        // Dealing with password
            user.setPassword(passwordEncoder.encode(password)); 
            user.setPassword(password); 
        }
    }


