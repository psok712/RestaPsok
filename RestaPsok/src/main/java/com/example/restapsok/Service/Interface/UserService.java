package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    String deleteUser(Long id);
    User updateUser(Long id, User user);
    User createUser(User user);
    User getUserById(Long id);
}
