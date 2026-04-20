package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NeedsType;

@Repository
public interface NeedsTypeRepository extends JpaRepository<NeedsType, Long> {
    
}
