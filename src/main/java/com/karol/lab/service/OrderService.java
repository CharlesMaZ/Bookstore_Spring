package com.karol.lab.service;

import com.karol.lab.model.*;
import com.karol.lab.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    //todo zapisywanie ksiazki do
    private UserService userService;
    private CartService cartService;
    private OrderRepository orderRepository;
    @Transactional
    public Order submitOrder(){
        User user = userService.getCurrentUser();
        Cart cart = user.getCart();

        Order order = new Order();
        order.setDate(new Date());
        order.setStatus(OrderStatus.SUBMITTED);
        order.setUser(user);

        for (CartItem cartItem : cart.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            order.getOrderItems().add(orderItem);
        }

        cart.getItems().clear();
        cartService.saveCart(cart);

        return orderRepository.save(order);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow(() -> new RuntimeException("nie znaleziono zamówienia"));
    }
}
