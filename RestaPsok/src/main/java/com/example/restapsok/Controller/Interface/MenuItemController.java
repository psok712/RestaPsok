package com.example.restapsok.Controller.Interface;

import com.example.restapsok.Model.MenuItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuItemController {
    ResponseEntity<List<MenuItem>> getAllMenu();
    ResponseEntity<MenuItem> getMenuItemById(Long id);
}
