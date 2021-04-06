package com.example.hk_2.dao;

import com.example.hk_2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    List<User> findById(long id);
    List<User> findByName(String name);
    List<User> findByIdIn(List<Long> id);
}
