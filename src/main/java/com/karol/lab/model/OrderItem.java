package com.karol.lab.model;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
public class OrderItem {


    @ManyToOne
    @JoinColumn(name = "orders")
    private Order order;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    //@ManyToMany
    private Book book;
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
