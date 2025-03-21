package com.mentorize.mentorize_backend.enums;


public enum UserRole {
    ADMIN("ADMIN"),
    BASIC("BASIC");

    private final String role;

    UserRole(String role){
        this.role = role;
    }


    public String getRole(){
        return role;
    }
}
