package com.example.hk_2.dao;

import com.example.hk_2.entities.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassageRepository extends JpaRepository<Passage, Long> {
    List<Passage> findByUser(long user);
    List<Passage> findByUserIn(List<Long> users);
}
