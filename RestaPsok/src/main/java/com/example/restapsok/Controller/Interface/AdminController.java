package com.example.restapsok.Controller.Interface;

import com.example.restapsok.Model.MenuItem;
import org.springframework.http.ResponseEntity;

public interface AdminController {
    ResponseEntity<String> createMenuItem(String admin, String password, MenuItem user);
    ResponseEntity<String> deleteMenuItem(String admin, String password, Long id);
}
