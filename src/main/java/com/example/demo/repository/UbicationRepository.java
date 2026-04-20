package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ubication;

@Repository
public interface UbicationRepository extends JpaRepository<Ubication, Long> {
    
}
