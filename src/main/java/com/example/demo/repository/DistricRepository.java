package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Distric;

@Repository
public interface DistricRepository extends JpaRepository<Distric, Long> {
    
}
