package com.plinio.circuitbreaker.controllers.v1;

import com.plinio.circuitbreaker.entities.Job;
import com.plinio.circuitbreaker.services.JobsService;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/jobs")
public class JobsController {

    @Autowired
    public JobsService service;

    @GetMapping
    public ResponseEntity<List<Job>> getJobsList() {
        var jobs = service.getJobsList();
        if(jobs == null || jobs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(jobs);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.status(201).body(service.createJob(job));
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable UUID id) {
        return service.getJobByIId(id);
    }
}
