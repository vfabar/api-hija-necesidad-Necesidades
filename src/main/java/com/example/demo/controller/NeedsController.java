package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Needs;
import com.example.demo.service.NeedsService;

@RestController
@RequestMapping("/api/v1/Needs")
public class NeedsController {
    
       
    @Autowired
    private NeedsService needsService;

    @GetMapping
    public ResponseEntity<List<Needs>> getAllNeds() {
        List<Needs> needs = needsService.findAll();
        if (needs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(needs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Needs> getNeedsById(@PathVariable Long id) {
        Needs needs = needsService.findById(id);
        if (needs == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(needs);
    }

    @PostMapping
    public ResponseEntity<Needs> createNeeds(@RequestBody Needs needs) {
        Needs savedNeeds = needsService.save(needs);
        return ResponseEntity.status(201).body(savedNeeds);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeeds(@PathVariable Long id) {
        needsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
