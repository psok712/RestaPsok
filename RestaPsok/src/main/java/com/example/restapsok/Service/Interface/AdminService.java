package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.MenuItem;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<String> createMenuItem(MenuItem user);
    ResponseEntity<String> deleteMenuItem(Long id);
    ResponseEntity<String> statisticsOrder();
}
