package com.example.restapsok.Service;

import com.example.restapsok.Model.OrderPosition;
import com.example.restapsok.Model.StatusOrder;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Service.Interface.OrderPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPositionServiceImpl implements OrderPositionService {

    @Autowired
    private OrderPositionRepository orders;

    public OrderPositionServiceImpl(OrderPositionRepository orderRepository) {
        orders = orderRepository;
    }

    public List<OrderPosition> getAllOrders() {
        return orders.findAll();
    }

    public OrderPosition getOrderById(Long id) {
        if (orders.findById(id).isEmpty()) {
            return new OrderPosition();
        }

        return orders.findById(id).get();
    }

    public OrderPosition createOrder(OrderPosition orderPosition) {
        return orders.save(orderPosition);
    }

    // todo: меняет id после изменения статуса
    public String cancelOrder(Long id) {
        if (orders.findById(id).isEmpty()) {
            return "There is no such order!";
        }

        var order = orders.findById(id).get();
        order.statusOrder = StatusOrder.CANCELLED;
        orders.delete(orders.findById(id).get());
        orders.save(order);
        return "Order status updated! The order " + order.id + " has now been cancelled.";
    }

    // todo: меняет id после изменения статуса
    public String payOrder(Long id) {
        if (orders.findById(id).isEmpty()) {
            return "There is no such order!";
        }

        var order = orders.findById(id).get();
        order.statusOrder = StatusOrder.PAYED;
        order.id = orders.findById(id).get().getId();
        orders.delete(orders.findById(id).get());
        orders.save(order);
        return "Order status updated! The order " + order.id + " has now been payed.";
    }
}
