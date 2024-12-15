package com.jk.jkprintify.service;

import com.jk.jkprintify.model.Order;
import com.jk.jkprintify.repo.OrderRepository;
import com.jk.jkprintify.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public Order placeOrder(Order order, Long serviceId) {
        // Fetch the service from the database using the serviceId
        com.jk.jkprintify.model.Service service = serviceRepository.findById(serviceId).orElseThrow(() -> new RuntimeException("Service not found"));

        // Set the service to the order
        order.setService((com.jk.jkprintify.model.Service) service);

        // Set additional fields for the order
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        // Save the order to the database
        return orderRepository.save(order);
    }

    // Other order-related methods can be added here (e.g., getOrders, getOrderById, etc.)
}