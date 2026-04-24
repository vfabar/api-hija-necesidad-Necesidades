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
@Table(name = "ubication")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbication;

    @Column(name = "street", nullable = false)
    private String street;

    @ManyToOne
    @JoinColumn(name = "idDistric",nullable = false)
    private Distric idDistric;
}
