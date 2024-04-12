package com.example.restapsok.Service;

import com.example.restapsok.Model.MenuItem;
import com.example.restapsok.Model.Review;
import com.example.restapsok.Repository.MenuItemRepository;
import com.example.restapsok.Repository.ReviewRepository;
import com.example.restapsok.Service.Interface.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminServiceImpl implements AdminService {

    private final MenuItemRepository _menu;
    private final ReviewRepository _reviews;

    public AdminServiceImpl(MenuItemRepository menu, ReviewRepository reviews) {
        _menu = menu;
        _reviews = reviews;
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

    public ResponseEntity<String> statisticsOrder() {
        var list = _reviews.findAll().stream().map(Review::getGrade).toList();
        var sumGrade = 0;

        for (var el : list) {
            sumGrade += el;
        }

        var avrGrade = list.isEmpty() ? 0 : (double)sumGrade / list.size();

        return list.isEmpty()
                ? new ResponseEntity<>("There are no reviews yet", HttpStatus.NOT_FOUND)
                : new ResponseEntity<>("Average rating: " + avrGrade + "/5", HttpStatus.OK);
    }
}
