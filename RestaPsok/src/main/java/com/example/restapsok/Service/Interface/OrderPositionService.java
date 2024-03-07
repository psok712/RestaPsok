package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.OrderPosition;
import com.example.restapsok.Model.StatusOrder;

import java.util.List;

public interface OrderPositionService {
    List<OrderPosition> getAllOrders();
    OrderPosition getOrderById(Long id);
    OrderPosition createOrder(OrderPosition orderPosition);
    String cancelOrder(Long id);
    String payOrder(Long id);
}
