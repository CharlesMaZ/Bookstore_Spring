package com.karol.lab.repository;

import com.karol.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookDAO {
    Optional<Book> getById(Long id); //Long

    List<Book> getAll();

    void saveOrUpdate(Book book);

    void delete(int id);
}


