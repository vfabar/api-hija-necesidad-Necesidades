package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Distric;
import com.example.demo.repository.DistricRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DistricService {
    
    @Autowired
    private DistricRepository districRepository;

    public List<Distric> findAll() {
        return districRepository.findAll();
    }

    public Distric findById(Long id) {
        return districRepository.findById(id).orElse(null);
    }

    public Distric save(Distric distric) {
        return districRepository.save(distric);
    }
    public void deleteById(Long id) {
        districRepository.deleteById(id);
    }    
}
