package com.karol.lab.repository;

import com.karol.lab.model.Cart;
import com.karol.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart save(Cart cart);
}
