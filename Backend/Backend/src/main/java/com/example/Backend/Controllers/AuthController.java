package com.example.Backend.Controllers;

import com.example.Backend.Models.DTOs.UserRegistrationDTO;
import com.example.Backend.Models.DTOs.UserLoginDTO; // Import the UserLoginDTO
import com.example.Backend.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register-user")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        try {
            authService.registerUser(userRegistrationDTO);
            return ResponseEntity.ok("User registered successfully with role: " + userRegistrationDTO.getRole());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO userLoginDTO) { // Updated to use UserLoginDTO
        String role = authService.loginUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (role != null) {
            return ResponseEntity.ok("Login Successful. Role: " + role);
        } else {
            return ResponseEntity.status(401).body("Invalid login, try again.");
        }
    }
}