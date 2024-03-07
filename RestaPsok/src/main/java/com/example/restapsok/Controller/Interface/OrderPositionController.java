package com.example.restapsok.Controller.Interface;

import com.example.restapsok.Model.OrderPosition;

import java.util.List;

public interface OrderPositionController {
    List<OrderPosition> getAllOrders();
    OrderPosition getOrderById(Long id);
    OrderPosition createOrder(OrderPosition orderPosition);
    String cancelOrder(Long id);
    String payOrder(Long id);
}
