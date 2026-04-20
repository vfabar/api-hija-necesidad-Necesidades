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

import com.example.demo.model.Distric;
import com.example.demo.service.DistricService;

@RestController
@RequestMapping("/api/v1/distric")
public class DistricController {
    
    @Autowired
    private DistricService districService;

    @GetMapping
    public ResponseEntity<List<Distric>> getAllDistrics() {
        List<Distric> districs = districService.findAll();
        if (districs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(districs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distric> getDistricById(@PathVariable Long id) {
        Distric distric = districService.findById(id);
        if (distric == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(distric);
    }

    @PostMapping
    public ResponseEntity<Distric> createDistric(Distric distric) {
        Distric savedDistric = districService.save(distric);
        return ResponseEntity.ok(savedDistric);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistric(@PathVariable Long id) {
        districService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
