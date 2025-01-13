package com.example.spring_personal_finance_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    private String username; 
    private String password; 
    private String firstName; 
    private String lastName; 
    private String role; 

    public User() {

    }

    public User(long id, String username, String password, String firstName, String lastName, String role) {
        this.id = id; 
        this.username = username; 
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.role = role; 
    }

    public User(String username, String password, String firstName, String lastName, String role) {
        this.username = username; 
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.role = role; 
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


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }

    

    
}
