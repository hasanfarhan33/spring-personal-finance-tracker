package com.example.spring_personal_finance_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_personal_finance_tracker.model.User;
import com.example.spring_personal_finance_tracker.repository.UserRepository;
import com.example.spring_personal_finance_tracker.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final UserService userService; 
    private final UserRepository userRepository; 

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService; 
        this.userRepository = userRepository; 
    }

    /**
     * Retrieves a list of all users.
     * 
     * @return a list of User objects
     */
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers(); 
    }

    /**
     * Retrieves a user by their ID.
     * 
     * @param userId the ID of the user
     * @return a ResponseEntity containing the User object or a NOT FOUND status
     */
    @GetMapping("/userById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long userId) {
        return userService.getUserById(userId)
                    .map(user -> ResponseEntity.ok().body(user))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return a ResponseEntity containing the user if found, or a 404 Not Found status if the user does not exist
     */
    @GetMapping("/userByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Retrieves a user by their email address.
     *
     * @param email the email address of the user to retrieve
     * @return a ResponseEntity containing the User object if found, or a ResponseEntity with a NOT_FOUND status if the user is not found
     */
    @GetMapping("/userByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Registers a new user.
     *
     * @param user the user to be registered
     * @return a ResponseEntity containing the registered user if successful, 
     *         or a ResponseEntity with a BAD_REQUEST status if registration fails
     */
    @PostMapping("/registerNewUser")
    public ResponseEntity<Object> registerNewUser(@RequestBody User user) {

        System.out.println("Received User: " + user.toString());

        if (user == null || user.getUsername() == null || user.getEmail() == null || user.getPassword() == null || user.getFirstName() == null || user.getLastName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
        }
        try {
            userService.registerNewUser(user); 
            return ResponseEntity.ok().body(user); 
        }
        catch(IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or email already taken");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }

    /**
     * Deletes a user by their user ID.
     *
     * @param userId the ID of the user to be deleted
     * @return a ResponseEntity indicating the result of the operation
     *         - 200 OK if the user was successfully deleted
     *         - 400 BAD REQUEST if there was an error during deletion
     */
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") long userId) {
        try {
            userService.deleteUser(userId); 
            return ResponseEntity.ok().build(); 
        } 
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }


    /**
     * Updates an existing user with the provided details.
     *
     * @param userId the ID of the user to be updated
     * @param firstName the new first name of the user
     * @param lastName the new last name of the user
     * @param username the new username of the user
     * @param role the new role of the user
     * @param password the new password of the user
     * @return a ResponseEntity indicating the result of the update operation
     */
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, String email, String firstName, String lastName, String username, String role, String password) {
        try{
            userService.updateUser(userId, firstName, lastName, username, email, role, password);
            return ResponseEntity.ok().build(); 
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }
}
