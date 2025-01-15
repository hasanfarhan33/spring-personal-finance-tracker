package com.example.spring_personal_finance_tracker.dto;

public class RegistrationRequest {
    private String username; 
    private String email; 
    private String password; 
    private String firstName; 
    private String lastName; 

    public RegistrationRequest(String username, String email, String password, String firstName, String lastName) {
        this.username = username; 
        this.email = email; 
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName; 
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


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }

}

