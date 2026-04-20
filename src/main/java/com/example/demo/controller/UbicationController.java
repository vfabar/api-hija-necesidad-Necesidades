package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UbicationService;
import com.example.demo.model.Ubication;

@RestController
@RequestMapping("/api/v1/ubication")
public class UbicationController {

    @Autowired
    private UbicationService ubicationService;

    @GetMapping
    public ResponseEntity<List<Ubication>> getAllUbications() {
        List<Ubication> ubications = ubicationService.findAll();
        if (ubications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ubications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubication> getUbicationById(@PathVariable Long id) {
        Ubication ubication = ubicationService.findById(id);
        if (ubication == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubication);
    }

    @PostMapping
    public ResponseEntity<Ubication> createUbication(Ubication ubication) {
        Ubication savedUbication = ubicationService.save(ubication);
        return ResponseEntity.ok(savedUbication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbication(@PathVariable Long id) {
        ubicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}




