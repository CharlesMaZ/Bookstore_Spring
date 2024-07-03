package com.karol.lab.service;

import com.karol.lab.model.Book;
import com.karol.lab.model.Cart;
import com.karol.lab.model.User;
import com.karol.lab.repository.CartRepository;
import com.karol.lab.repository.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private IBookDAO bookRepository;

    @Autowired
    private UserService userService;
    @Transactional
    public Cart getCart(){
        User user = userService.getCurrentUser();
        return user.getCart();
    }

    @Transactional
    public Cart addToCart(Long bookId, int quantity){
        Cart cart = getCart();
        Book book = bookRepository.getById(bookId).orElseThrow(() ->
                new RuntimeException("Boook not found"));
        cart.addItem(book, quantity);
        //cart.removeItem(book);
    return saveCart(cart);
    }

    @Transactional
    public Cart removeFromCart(Long bookId){
        Cart cart = getCart();
        Book book = bookRepository.getById(bookId).orElseThrow(()
        -> new RuntimeException("Book not found"));
        cart.removeItem(book);
        return saveCart(cart);
    }

    @Transactional
    public  Cart saveCart(Cart cart){
        //TODO cos tu nie bangla
        return cartRepository.save(cart);
    }
}
