package com.example.Backend.Services;

import com.example.Backend.Models.DTOs.UserRegistrationDTO;
import com.example.Backend.Models.entity.Role;
import com.example.Backend.Models.entity.User;
import com.example.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setProfilePicture(userRegistrationDTO.getProfilePicture());
        user.setVerificationDocument(userRegistrationDTO.getVerificationDocument());


        try {
            Role role = Role.fromString(userRegistrationDTO.getRole());
            user.setRole(role);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role provided: " + userRegistrationDTO.getRole());
        }

        userRepository.save(user);
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user.getRole().toString();
        }
        return null;
    }
}