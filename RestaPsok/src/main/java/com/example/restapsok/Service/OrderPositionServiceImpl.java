package com.example.restapsok.Service;

import com.example.restapsok.Model.OrderPosition;
import com.example.restapsok.Model.StatusOrder;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Service.Interface.OrderPositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPositionServiceImpl implements OrderPositionService {

    // TODO: написать весь функционал методов
    private final OrderPositionRepository orders;
    public OrderPositionServiceImpl(OrderPositionRepository orderRepository) {
        orders = orderRepository;
    }

    public List<OrderPosition> getAllOrders() {
        return null;
    }


    public OrderPosition getOrderById(Long id) {
        return null;
    }

    @Override
    public OrderPosition createOrder(OrderPosition orderPosition) {
        return null;
    }

    @Override
    public String cancelOrder(Long id) {
        return null;
    }

    @Override
    public String payOrder(Long id) {
        return null;
    }
}
