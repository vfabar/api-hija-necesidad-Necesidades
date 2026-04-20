package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ubication;
import com.example.demo.repository.UbicationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UbicationService {
    
    @Autowired
    private UbicationRepository ubicationRepository;


    public List<Ubication> findAll() {
        return ubicationRepository.findAll();
    }

    public Ubication findById(Long id) {
        return ubicationRepository.findById(id).orElse(null);
    }

    public Ubication save(Ubication ubication) {
        return ubicationRepository.save(ubication);
    }
    public void deleteById(Long id) {
        ubicationRepository.deleteById(id);
    }

}
