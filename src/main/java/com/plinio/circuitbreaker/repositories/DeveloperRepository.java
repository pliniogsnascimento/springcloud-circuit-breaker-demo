package com.plinio.circuitbreaker.repositories;

import com.plinio.circuitbreaker.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, String> {
}
