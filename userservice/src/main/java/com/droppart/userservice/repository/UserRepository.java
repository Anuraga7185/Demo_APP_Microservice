package com.droppart.userservice.repository;

import com.droppart.userservice.model.User;
import com.droppart.userservice.model.helper.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    List<User> findByRole(UserRole role);
    List<User> findByActiveTrue();

    List<User> findByRoleAndActiveTrue(UserRole role);
}
