package com.example.restapsok.Service;

import com.example.restapsok.Model.MenuItem;
import com.example.restapsok.Repository.MenuItemRepository;
import com.example.restapsok.Service.Interface.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminServiceImpl implements AdminService {

    private final MenuItemRepository _menu;

    public AdminServiceImpl(MenuItemRepository menu) {
        _menu = menu;
    }

    public ResponseEntity<String> createMenuItem(MenuItem menuItem) {
        _menu.save(menuItem);
        return new ResponseEntity<>("Dish added to menu.", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMenuItem(Long id) {
        if (_menu.findById(id).isEmpty()) {
            return new ResponseEntity<>("No such dish found!", HttpStatus.NOT_FOUND);
        }

        _menu.deleteById(id);
        return new ResponseEntity<>("The dish was successfully deleted.", HttpStatus.OK);
    }
}
