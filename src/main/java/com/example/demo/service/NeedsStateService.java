package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.NeedsState;
import com.example.demo.repository.NeedsStateRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NeedsStateService {
    
    @Autowired
    private NeedsStateRepository needsStateRepository;


    public List<NeedsState> findAll() {
        return needsStateRepository.findAll();
    }

    public NeedsState findById(Long id) {
        return needsStateRepository.findById(id).orElse(null);
    }

    public NeedsState save(NeedsState needsState) {
        return needsStateRepository.save(needsState);
    }
    public void deleteById(Long id) {
        needsStateRepository.deleteById(id);
    }
    
}
