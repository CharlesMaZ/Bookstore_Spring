package com.karol.lab.service;

import com.karol.lab.model.Book;
import com.karol.lab.repository.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private final IBookDAO bookDAO;

    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Book book) {
        this.bookDAO.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public Optional<Book> getById(Long id) {
        return this.bookDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return this.bookDAO.getAll();
    }

    @Override
    public void delete(int id) {
        //this.
        bookDAO.delete(id);
    }
}
