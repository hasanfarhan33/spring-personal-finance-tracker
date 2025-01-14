package com.example.spring_personal_finance_tracker.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.spring_personal_finance_tracker.model.User;
import com.example.spring_personal_finance_tracker.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; 
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

    // GET ONE USER BY EMAIL 
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email); 
    }

    // ADD A USER 
    public void registerNewUser(User user) {

        System.out.println(user.toString());

        Optional<User> usernameOptional = userRepository.findByUsername(user.getUsername()); 
        Optional<User> emailOptional = userRepository.findByEmail(user.getEmail()); 

        if(usernameOptional.isPresent()) {
            logger.warn("The username is taken");
            throw new IllegalStateException("Username \"" + user.getUsername() + "\" is already taken"); 
        }

        if(emailOptional.isPresent()) {
            logger.warn("The email is taken");
            throw new IllegalStateException("Email \"" + user.getEmail() + "\" is already taken"); 
        }

        userRepository.save(user); 
    }

    // REMOVE A USER 
    public void deleteUser(long userId) {
        Optional<User> userOptional = userRepository.findById(userId); 

        if(!userOptional.isPresent()) {
            logger.warn("The user does not exist");
            throw new IllegalStateException("The user with user ID" + userId + " does not exist"); 
        }

        userRepository.deleteById(userId);
    }

    // UPDATE A USER 
    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String username, String email, String role, String password) {
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

        // Dealing with email 
        if(email != null && email.length() > 0 && !Objects.equals(email, user)) {
            Optional<User> userOptional = userRepository.findByEmail(email); 

            if(userOptional.isPresent()) {
                System.out.println("The email is taken");
                throw new IllegalStateException("Email \"" + email + "\" is already taken");
            }

            user.setEmail(email); 
        }

        // Dealing with role
        if(role != null && role.length() > 0 && !Objects.equals(role, user)) {
            user.setRole(role); 
        }

        // Dealing with password
        if(password != null && password.length() > 0 && !Objects.equals(password, user)) {
            user.setPassword(password);

        }
    }
}


