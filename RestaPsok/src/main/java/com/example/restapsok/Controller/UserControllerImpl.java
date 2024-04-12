package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.UserController;
import com.example.restapsok.Model.User;
import com.example.restapsok.Repository.UserRepository;
import com.example.restapsok.Service.Interface.UserService;
import com.example.restapsok.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository users;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        UserService service = new UserServiceImpl(users);
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        UserService service = new UserServiceImpl(users);
        return service.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        UserService service = new UserServiceImpl(users);
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        UserService service = new UserServiceImpl(users);
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable Long id) {
        UserService service = new UserServiceImpl(users);
        return service.deleteUser(id);
    }
}
