package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Needs;
import com.example.demo.repository.NeedsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NeedsService {
    
    @Autowired
    private NeedsRepository needsRepository;

    public List<Needs> findAll() {
        return needsRepository.findAll();
    }

    public Needs findById(Long id) {
        return needsRepository.findById(id).orElse(null);
    }

    public Needs save(Needs needs) {
        return needsRepository.save(needs);
    }
    public void deleteById(Long id) {
        needsRepository.deleteById(id);
    }

}
