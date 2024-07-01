package com.karol.lab.repository;

import com.karol.lab.model.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements IBookDAO{
    @PersistenceContext
    private EntityManager entityManager;
    private final String GET_ALL_JPQL = "FROM com.karol.lab.model.Book";

    public BookDAO(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    public Optional<Book> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getAll(){
        TypedQuery<Book> query = entityManager.createQuery(GET_ALL_JPQL, Book.class);
        List<Book> result = query.getResultList();
        return result;

    }

    @Override
    public void saveOrUpdate(Book book) {

    }

    @Override
    public void delete(int id) {

    }
}
