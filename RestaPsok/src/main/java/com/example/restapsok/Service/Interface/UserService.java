package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();
    HttpStatus deleteUser(Long id);
    ResponseEntity<User> updateUser(Long id, User user);
    ResponseEntity<User> createUser(User user);
    ResponseEntity<User> getUserById(Long id);
}
