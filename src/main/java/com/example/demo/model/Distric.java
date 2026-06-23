package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "distric")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distric {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistric;

    @Column(name = "distric", nullable = false)
    private String distric;

    @ManyToOne
    @JoinColumn (name = "idRegion", nullable = false)
    private Region idRegion;
}
