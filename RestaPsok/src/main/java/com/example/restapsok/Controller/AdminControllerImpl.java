package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.AdminController;
import com.example.restapsok.Model.MenuItem;
import com.example.restapsok.Model.Role;
import com.example.restapsok.Model.User;
import com.example.restapsok.Repository.MenuItemRepository;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Repository.UserRepository;
import com.example.restapsok.Service.AdminServiceImpl;
import com.example.restapsok.Service.Interface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/{admin}/{password}")
@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    MenuItemRepository menu;
    @Autowired
    UserRepository users;
    @Autowired
    OrderPositionRepository orders;

    @PostMapping
    public ResponseEntity<String> createMenuItem(
            @PathVariable String admin,
            @PathVariable String password,
            @RequestBody MenuItem menuItem
    )
    {
        if (!checkingDetailsAdmin(admin, password)) {
            return new ResponseEntity<>(
                    "You do not have sufficient rights to perform this action!",
                    HttpStatus.BAD_REQUEST
            );
        }

        AdminService service = new AdminServiceImpl(menu);
        return service.createMenuItem(menuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuItem(
            @PathVariable String admin,
            @PathVariable String password,
            @PathVariable Long id
    )
    {
        if (!checkingDetailsAdmin(admin, password)) {
            return new ResponseEntity<>(
                    "You do not have sufficient rights to perform this action!",
                    HttpStatus.BAD_REQUEST
            );
        }

        AdminService service = new AdminServiceImpl(menu);
        return service.deleteMenuItem(id);
    }

    private boolean checkingDetailsAdmin(String admin, String password)
    {
        var repositoryUser = users.findAll();

        for (User el : repositoryUser) {
            if (el.getUsername().equals(admin) && el.getPassword().equals(password) && el.role == Role.ADMIN)
                return true;
        }

        return false;
    }
}
