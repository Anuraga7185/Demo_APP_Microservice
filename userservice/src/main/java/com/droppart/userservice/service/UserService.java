package com.droppart.userservice.service;

import com.droppart.userservice.model.User;
import com.droppart.userservice.model.helper.UserRole;
import com.droppart.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findByActiveTrue();
    }

    public List<User> getAllDeliveryPartners() {
        return userRepository.findByRoleAndActiveTrue(UserRole.DELIVERY_PARTNER);
    }

    public List<User> getAllAdmins() {
        return userRepository.findByRole(UserRole.ADMIN);
    }
}
