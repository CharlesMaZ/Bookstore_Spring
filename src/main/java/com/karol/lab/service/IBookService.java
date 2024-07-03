package com.karol.lab.service;

import com.karol.lab.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public interface IBookService {
    void saveOrUpdate(Book book);
    Optional<Book> getById(Long id);
    List<Book> getAll();

    void delete(Long id);
}
