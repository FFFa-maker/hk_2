package com.example.hk_2.dao;


import com.example.hk_2.entities.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Long> {
    List<Relation> findByA(long a);
    List<Relation> findByB(long b);
    List<Relation> findByAOrB(long sb1, long sb2);
    List<Relation> findByAAndB(long sb1, long sb2);
    boolean existsByAAndB(long a, long b);
}
