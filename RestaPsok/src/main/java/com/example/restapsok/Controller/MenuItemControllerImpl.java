package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.MenuItemController;
import com.example.restapsok.Model.MenuItem;
import com.example.restapsok.Repository.MenuItemRepository;
import com.example.restapsok.Service.Interface.MenuItemService;
import com.example.restapsok.Service.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/menu")
@RestController
public class MenuItemControllerImpl implements MenuItemController {

    @Autowired
    MenuItemRepository menu;

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenu() {
        MenuItemService service = new MenuItemServiceImpl(menu);
        return service.getAllMenu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        MenuItemService service = new MenuItemServiceImpl(menu);
        return service.getMenuItemById(id);
    }

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItemService service = new MenuItemServiceImpl(menu);
        return service.createMenuItem(menuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        MenuItemService service = new MenuItemServiceImpl(menu);
        return service.deleteMenuItem(id);
    }
}
