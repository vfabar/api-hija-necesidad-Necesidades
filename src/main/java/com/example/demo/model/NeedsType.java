package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "needsType")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeedsType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNeedsType;

    @Column(name = "needs_type", nullable = false)
    private String needsType;
}
