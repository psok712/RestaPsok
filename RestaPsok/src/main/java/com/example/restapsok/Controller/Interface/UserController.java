package com.example.restapsok.Controller.Interface;

import com.example.restapsok.Model.User;
import java.util.List;
import java.util.UUID;

public interface UserController {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    String deleteUser(Long id);
}
