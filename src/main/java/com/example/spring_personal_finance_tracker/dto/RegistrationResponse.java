package com.example.spring_personal_finance_tracker.dto;

public class RegistrationResponse {

    private String message; 

    public RegistrationResponse(String message) {
        this.message = message; 
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
