package com.example.restapsok.Controller.Interface;

import com.example.restapsok.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<User> getUserById(Long id);
    ResponseEntity<User> createUser(User user);
    ResponseEntity<User> updateUser(Long id, User user);
    HttpStatus deleteUser(Long id);
}
