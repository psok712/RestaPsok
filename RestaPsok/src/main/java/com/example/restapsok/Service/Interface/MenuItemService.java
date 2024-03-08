package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.MenuItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuItemService {
    ResponseEntity<List<MenuItem>> getAllMenu();
    ResponseEntity<MenuItem> getMenuItemById(Long id);
    ResponseEntity<MenuItem> createMenuItem(MenuItem menuItem);
    ResponseEntity<String> deleteMenuItem(Long id);
}
