package com.example.restapsok.Service;

import com.example.restapsok.Exception.UserNotFoundException;
import com.example.restapsok.Model.User;
import com.example.restapsok.Repository.UserRepository;
import com.example.restapsok.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    public UserServiceImpl(UserRepository userRepository) {
        users = userRepository;
    }

    public List<User> getAllUsers() {
        return users.findAll();
    }

    public User updateUser(Long id, User user) {
        if (users.findById(id).isEmpty()) {
            return new User();
        }

        User existingUser = users.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return users.save(existingUser);
    }

    public User createUser(User user) {
        return users.save(user);
    }

    public User getUserById(Long id) {

        if (users.findById(id).isEmpty()) {
            return new User();
        }

        return users.findById(id).get();
    }

    public String deleteUser(Long id) {
        if (users.findById(id).isEmpty()) {
            return "User not found";
        }

        String message = "User " + users.findById(id).get().getUsername() + " deleted successfully";
        users.deleteById(id);
        return message;
    }
}
