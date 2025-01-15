package com.example.spring_personal_finance_tracker.dto;

public class LoginResponse {

    private String message;  

    public LoginResponse() {}

    public LoginResponse(String message) {
        this.message = message; 
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
