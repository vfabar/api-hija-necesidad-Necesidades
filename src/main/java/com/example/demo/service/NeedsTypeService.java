package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.NeedsType;
import com.example.demo.repository.NeedsTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NeedsTypeService {
    
    @Autowired
    private NeedsTypeRepository needsTypeRepository;

    public List<NeedsType> findAll() {
        return needsTypeRepository.findAll();
    }

    public NeedsType findById(Long id) {
        return needsTypeRepository.findById(id).orElse(null);
    }

    public NeedsType save(NeedsType needsType) {
        return needsTypeRepository.save(needsType);
    }
    public void deleteById(Long id) {
        needsTypeRepository.deleteById(id);
    }
}
