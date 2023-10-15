package com.plinio.circuitbreaker.repositories;

import com.plinio.circuitbreaker.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobsRepository extends JpaRepository<Job, UUID> {
}
