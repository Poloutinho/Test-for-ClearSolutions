package com.example.testforclearsolutions.dao;

import com.example.testforclearsolutions.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;

@Service
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    private UserDao userDao;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findByBirthDateBetween(Date from, Date to) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public User save(User user) {
        // Use EntityManager to persist the user entity
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public void deleteById(Long userId) {
        // Use EntityManager to remove the user entity by ID
        User userToDelete = entityManager.find(User.class, userId);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    @Override
    @Transactional
    public User add(User entity) {
        // Use EntityManager to persist the user entity
        entityManager.persist(entity);
        return entity;
    }
}
