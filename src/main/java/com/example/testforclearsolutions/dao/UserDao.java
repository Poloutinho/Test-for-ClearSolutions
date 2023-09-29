package com.example.testforclearsolutions.dao;

import com.example.testforclearsolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends GenericDao<User> {

    List<User> findByBirthDateBetween(Date from, Date to);

    Optional<User> findById(Long aLong);

    User save(User user);

    void deleteById(Long userId);
}
