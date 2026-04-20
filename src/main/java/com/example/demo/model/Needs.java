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
@Table(name = "needs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Needs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNeeds;

    @Column(name = "needs", nullable = false)
    private String needs;

    @ManyToOne
    @JoinColumn(name = "idNeedsState", nullable = false)
    private NeedsState needsState;

    @ManyToOne
    @JoinColumn(name = "idNeedsType", nullable = false)
    private NeedsType needsType;
}
