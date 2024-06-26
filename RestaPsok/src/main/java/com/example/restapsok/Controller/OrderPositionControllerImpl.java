package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.OrderPositionController;
import com.example.restapsok.Model.OrderPosition;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Service.Interface.OrderPositionService;
import com.example.restapsok.Service.OrderPositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order")
@RestController
public class OrderPositionControllerImpl implements OrderPositionController {

    @Autowired
    private OrderPositionRepository orders;

    @GetMapping
    public ResponseEntity<List<OrderPosition>> getAllOrders() {
        OrderPositionService service = new OrderPositionServiceImpl(orders);
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderPosition> getOrderById(@PathVariable Long id) {
        OrderPositionService service = new OrderPositionServiceImpl(orders);
        return service.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<OrderPosition> createOrder(@RequestBody OrderPosition orderPosition) {
        OrderPositionService service = new OrderPositionServiceImpl(orders);
        return service.createOrder(orderPosition);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
        OrderPositionService service = new OrderPositionServiceImpl(orders);
        return service.cancelOrder(id);
    }

    @PutMapping("/pay/{id}")
    public ResponseEntity<String> payOrder(@PathVariable Long id) {
        OrderPositionService service = new OrderPositionServiceImpl(orders);
        return service.payOrder(id);
    }
}
