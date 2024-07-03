package com.karol.lab.controller;

import com.karol.lab.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/add/{bookId}/{quantity}")
    public String addToCart(@PathVariable Long bookId, @PathVariable int quantity) {
        cartService.addToCart(bookId, quantity);
        return "redirect:/cart";
    }

//    @GetMapping
//    public String getCart(Model model) {
//        Cart cart = cartService.getCart();
//        model.addAttribute("cart", cart);
//        return "cart";
//    }

}
