package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.OrderPosition;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderPositionService {
    ResponseEntity<List<OrderPosition>> getAllOrders();
    ResponseEntity<OrderPosition> getOrderById(Long id);
    ResponseEntity<OrderPosition> createOrder(OrderPosition orderPosition);
    ResponseEntity<String> cancelOrder(Long id);
    ResponseEntity<String> payOrder(Long id);
}
