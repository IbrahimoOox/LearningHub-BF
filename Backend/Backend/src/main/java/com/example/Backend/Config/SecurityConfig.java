package com.example.Backend.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/auth/register-user") // Disable CSRF protection for the register endpoint
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/register-user").permitAll() // Allow registration without authentication
                        .requestMatchers("/api/auth/login").permitAll() // Allow login without authentication
                        .anyRequest().authenticated() // All other endpoints require authentication
                );

        return http.build();
    }

}
