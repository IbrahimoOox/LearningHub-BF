package com.example.Backend.Models.entity;

import lombok.Getter;

@Getter

public enum Role {
    ADMIN("Administrator"),
    PROFESSOR("Professor"),
    STUDENT("Student"),
    USER("User");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }


    public static Role fromString(String role) {
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}