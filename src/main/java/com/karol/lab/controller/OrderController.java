package com.karol.lab.controller;

import com.karol.lab.model.Order;
import com.karol.lab.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/order")
    public class orderController {
        @Autowired
        private OrderService orderService;
        @PostMapping("/submit")
        public String submitOrder() {
            Order order = orderService.submitOrder();
            return "redirect:/order/" +
                    order.getId();
        }
        @GetMapping("/{orderId}")
        public String getOrder(@PathVariable Long
                                       orderId, Model model) {
            Order order =
                    orderService.getOrder(orderId);
            model.addAttribute("order", order);
            return "order";
        }
    }
}
