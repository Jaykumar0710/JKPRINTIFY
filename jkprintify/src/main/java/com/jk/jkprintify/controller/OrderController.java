package com.jk.jkprintify.controller;


import com.jk.jkprintify.model.Order;
import com.jk.jkprintify.repo.ServiceRepository;
import com.jk.jkprintify.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        // Fetch available services from the database
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("order", new Order());
        return "order-form"; // name of the HTML view (order-form.html)
    }

    @PostMapping("/submit")
    public String submitOrder(@ModelAttribute Order order, @RequestParam Long serviceId) {
        orderService.placeOrder(order, serviceId); // Place the order and save it
        return "redirect:/orders/success"; // Redirect to a success page
    }

    @GetMapping("/success")
    public String orderSuccess() {
        return "order-success"; // name of the success page (order-success.html)
    }

    // You can add more controller methods for managing orders (view, update, delete, etc.)
}