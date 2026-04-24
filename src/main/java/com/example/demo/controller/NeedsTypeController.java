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

import com.example.demo.model.NeedsType;
import com.example.demo.service.NeedsTypeService;

@RestController
@RequestMapping("/api/v1/NeedsType")
public class NeedsTypeController {
    
       
    @Autowired
    private NeedsTypeService needsTypeService;

    @GetMapping
    public ResponseEntity<List<NeedsType>> getAllNeedsTypes() {
        List<NeedsType> needsTypes = needsTypeService.findAll();
        if (needsTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(needsTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NeedsType> getNeedsTypeById(@PathVariable Long id) {
        NeedsType needsType = needsTypeService.findById(id);
        if (needsType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(needsType);
    }

    @PostMapping
    public ResponseEntity<NeedsType> createNeedsType(@RequestBody NeedsType needsType) {
        NeedsType savedNeedsType = needsTypeService.save(needsType);
        return ResponseEntity.status(201).body(savedNeedsType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeedsType(@PathVariable Long id) {
        needsTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
