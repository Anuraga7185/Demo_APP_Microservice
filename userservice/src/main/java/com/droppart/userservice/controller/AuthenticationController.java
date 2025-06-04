package com.droppart.userservice.controller;

import com.droppart.userservice.dto.LoginRequest;
import com.droppart.userservice.dto.SignupRequest;
import com.droppart.userservice.model.User;
import com.droppart.userservice.repository.UserRepository;
import com.droppart.userservice.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().body("User successfully registered!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        org.springframework.security.core.userdetails.User newUser = new org.springframework.security.core.userdetails.User(user.getUsername(), "", new ArrayList<>());

        String jwtToken = jwtUtils.generateJwtToken(newUser);
        return ResponseEntity.ok(Collections.singletonMap("token", jwtToken));
    }



}
