package com.droppart.userservice.controller;

import com.droppart.userservice.model.User;
import com.droppart.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/delivery-partners")
    public ResponseEntity<List<User>> getAllDeliveryPartners() {
        return ResponseEntity.ok(userService.getAllDeliveryPartners());
    }
}
