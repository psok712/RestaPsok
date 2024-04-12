package com.example.restapsok.Service;

import com.example.restapsok.Model.User;
import com.example.restapsok.Repository.UserRepository;
import com.example.restapsok.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    public UserServiceImpl(UserRepository userRepository) {
        users = userRepository;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(users.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Long id) {
        if (users.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(Long id, User user) {
        if (users.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User existingUser = users.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return new ResponseEntity<>(users.save(existingUser), HttpStatus.OK);
    }

    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntity<>(users.save(user), HttpStatus.OK);
    }


    public HttpStatus deleteUser(Long id) {
        if (users.findById(id).isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }

        users.deleteById(id);
        return HttpStatus.OK;
    }
}
