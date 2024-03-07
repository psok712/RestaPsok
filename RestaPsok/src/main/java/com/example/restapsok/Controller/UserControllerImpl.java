package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.UserController;
import com.example.restapsok.Model.User;
import com.example.restapsok.Repository.UserRepository;
import com.example.restapsok.Service.Interface.UserService;
import com.example.restapsok.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository users;

    @GetMapping
    public List<User> getAllUsers() {
        UserService service = new UserServiceImpl(users);
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        UserService service = new UserServiceImpl(users);
        return service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        UserService service = new UserServiceImpl(users);
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        UserService service = new UserServiceImpl(users);
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService service = new UserServiceImpl(users);
        return service.deleteUser(id);
    }
}
