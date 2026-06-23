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

import com.example.demo.model.NeedsState;
import com.example.demo.service.NeedsStateService;

@RestController
@RequestMapping("/NeedsState")
public class NeedsStateController {
 
       
    @Autowired
    private NeedsStateService needsStateService;

    @GetMapping
    public ResponseEntity<List<NeedsState>> getAllNeedsStates() {
        List<NeedsState> needsStates = needsStateService.findAll();
        if (needsStates.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(needsStates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NeedsState> getNeedsStateById(@PathVariable Long id) {
        NeedsState needsState = needsStateService.findById(id);
        if (needsState == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(needsState);
    }

    @PostMapping
    public ResponseEntity<NeedsState> createNeedsState(@RequestBody NeedsState needsState) {
        NeedsState savedNeedsState = needsStateService.save(needsState);
        return ResponseEntity.status(201).body(savedNeedsState);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeedsState(@PathVariable Long id) {
        needsStateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
