package com.karol.lab.repository;

import com.karol.lab.model.Cart;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CartRepositoryImpl implements CartRepository{
    private EntityManager entityManager;
    @Override
    public Cart save(Cart cart) {
        entityManager.persist(cart);
        return cart;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Cart> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Cart> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cart getOne(Integer integer) {
        return null;
    }

    @Override
    public Cart getById(Integer integer) {
        return null;
    }

    @Override
    public Cart getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Cart> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cart> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cart> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cart> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cart> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cart, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Cart> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Cart> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public List<Cart> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Cart entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cart> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Cart> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return null;
    }
}
