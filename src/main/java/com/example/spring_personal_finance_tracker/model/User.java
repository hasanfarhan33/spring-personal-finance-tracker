package com.example.spring_personal_finance_tracker.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Represents a user in the personal finance tracker application.
 * This entity is mapped to a database table using JPA annotations.
 * 
 * Fields:
 * - id: The unique identifier for the user.
 * - username: The username of the user.
 * - email: The email address of the user.
 * - password: The password of the user.
 * - firstName: The first name of the user.
 * - lastName: The last name of the user.
 * - role: The role of the user (e.g., admin, user).
 * - createdAt: The timestamp when the user was created.
 * 
 * Constructors:
 * - User(): Default constructor.
 * - User(long id, String username, String email, String password, String firstName, String lastName, String role): 
 *   Constructor with all fields including id.
 * - User(String username, String email, String password, String firstName, String lastName, String role): 
 *   Constructor without id, id is auto-generated.
 * 
 * Methods:
 * - getId(): Returns the user's id.
 * - setId(long id): Sets the user's id.
 * - getUsername(): Returns the user's username.
 * - setUsername(String username): Sets the user's username.
 * - getEmail(): Returns the user's email.
 * - setEmail(String email): Sets the user's email.
 * - getPassword(): Returns the user's password.
 * - setPassword(String password): Sets the user's password.
 * - getFirstName(): Returns the user's first name.
 * - setFirstName(String firstName): Sets the user's first name.
 * - getLastName(): Returns the user's last name.
 * - setLastName(String lastName): Sets the user's last name.
 * - getRole(): Returns the user's role.
 * - setRole(String role): Sets the user's role.
 * - getCreatedAt(): Returns the timestamp when the user was created.
 * - setCreatedAt(Timestamp createdAt): Sets the timestamp when the user was created.
 * - toString(): Returns a string representation of the user.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;  
    @Column(nullable = false)
    private String password; 
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false) 
    private String lastName; 
    @Column(nullable = false)
    private String role; 
    @Column(nullable = false)
    private Timestamp createdAt;

    // Default constructor
    public User() {

    }

    public User(long id, String username, String email, String password, String firstName, String lastName, String role) {
        this.id = id; 
        this.username = username; 
        this.email = email; 
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.role = role; 

    }

    public User(String username, String email, String password, String firstName, String lastName, String role) {
        this.username = username; 
        this.email = email; 
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.role = role;        
    }

    @PrePersist 
    public void prePersist() {
        this.createdAt = Timestamp.from(java.time.Instant.now()); 
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
            "User{id=%d, username='%s', email='%s', password='%s', firstName='%s', lastName='%s', role='%s', createdAt='%s'}",
            id, username, email, password, firstName, lastName, role, createdAt
        );
    }

    
}
