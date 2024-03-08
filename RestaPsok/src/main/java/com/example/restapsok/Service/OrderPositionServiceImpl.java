package com.example.restapsok.Service;

import com.example.restapsok.Model.OrderPosition;
import com.example.restapsok.Model.StatusOrder;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Service.Interface.OrderPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPositionServiceImpl implements OrderPositionService {

    @Autowired
    private OrderPositionRepository orders;

    public OrderPositionServiceImpl(OrderPositionRepository orderRepository) {
        orders = orderRepository;
    }

    public ResponseEntity<List<OrderPosition>> getAllOrders() {
        return ResponseEntity.ok(orders.findAll());
    }

    public ResponseEntity<OrderPosition> getOrderById(Long id) {
        if (orders.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<OrderPosition> createOrder(OrderPosition orderPosition) {
        return new ResponseEntity<>(orders.save(orderPosition), HttpStatus.OK);
    }

    public ResponseEntity<String> cancelOrder(Long id) {
        if (orders.findById(id).isEmpty()) {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }

        OrderPosition order = orders.findById(id).get();
        order.setStatusOrder(StatusOrder.CANCELLED);
        orders.save(order);
        return new ResponseEntity<>("Good!", HttpStatus.OK);
    }

    public ResponseEntity<String> payOrder(Long id) {
        if (orders.findById(id).isEmpty()) {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }

        OrderPosition order = orders.findById(id).get();
        order.setStatusOrder(StatusOrder.PAYED);
        orders.save(order);
        return new ResponseEntity<>("Good!", HttpStatus.OK);
    }
}
