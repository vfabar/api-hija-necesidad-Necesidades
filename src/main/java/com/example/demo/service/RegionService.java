package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Region;
import com.example.demo.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {
    
    @Autowired
    private RegionRepository regionRepository;


    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }
    
}
