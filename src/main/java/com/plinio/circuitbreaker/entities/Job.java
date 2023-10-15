package com.plinio.circuitbreaker.entities;

import com.plinio.circuitbreaker.entities.Developer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String enterpriseName;
    private ArrayList<String> requiredStack;
    private ArrayList<String> preferableStack;
    @OneToMany(targetEntity = Developer.class, fetch = FetchType.EAGER)
    private Set<Developer> possibleCandidates;
}
