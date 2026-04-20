package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NeedsState;

@Repository
public interface NeedsStateRepository extends JpaRepository<NeedsState, Long> {
    
}
