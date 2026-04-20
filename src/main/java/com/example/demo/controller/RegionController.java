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

import com.example.demo.model.Region;
import com.example.demo.service.RegionService;

@RestController
@RequestMapping("/api/v1/")
public class RegionController {
    
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regions = regionService.findAll();
        if (regions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Region region = regionService.findById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(Region region) {
        Region savedRegion = regionService.save(region);
        return ResponseEntity.ok(savedRegion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}




