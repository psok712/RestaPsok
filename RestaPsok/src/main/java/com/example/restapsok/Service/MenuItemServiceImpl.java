package com.example.restapsok.Service;

import com.example.restapsok.Model.MenuItem;
import com.example.restapsok.Repository.MenuItemRepository;
import com.example.restapsok.Service.Interface.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    MenuItemRepository _menu;

    public MenuItemServiceImpl(MenuItemRepository menu) {
        _menu = menu;
    }

    public ResponseEntity<List<MenuItem>> getAllMenu() {
        return new ResponseEntity<>(_menu.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<MenuItem> getMenuItemById(Long id) {
        if (_menu.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(_menu.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<MenuItem> createMenuItem(MenuItem menuItem) {
        return new ResponseEntity<>(_menu.save(menuItem), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMenuItem(Long id) {
        if (_menu.findById(id).isEmpty()) {
            return new ResponseEntity<>("No such dish found!", HttpStatus.NOT_FOUND);
        }

        _menu.deleteById(id);
        return new ResponseEntity<>("The dish was successfully deleted!", HttpStatus.OK);
    }
}
