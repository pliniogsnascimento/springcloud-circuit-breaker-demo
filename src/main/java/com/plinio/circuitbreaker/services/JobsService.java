package com.plinio.circuitbreaker.services;

import com.plinio.circuitbreaker.clients.DevelopersClient;
import com.plinio.circuitbreaker.controllers.v1.*;
import com.plinio.circuitbreaker.entities.Developer;
import com.plinio.circuitbreaker.entities.Job;
import com.plinio.circuitbreaker.repositories.DeveloperRepository;
import com.plinio.circuitbreaker.repositories.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class JobsService {

    @Autowired
    private DevelopersClient developersClient;

    @Autowired
    private JobsRepository repository;
    @Autowired
    private DeveloperRepository devRepository;

    public List<Job> getJobsList() {
        return repository.findAll();
    }

    public Job getJobByIId(UUID id) {
        return repository.findById(id).stream().findFirst().orElse(null);
    }

    public Job createJob(Job job) {
        job.setPossibleCandidates(new HashSet<Developer>());
        for(String stackTerm: job.getRequiredStack()) {
            var developers = developersClient.getDevelopers(new GetDevelopersParams(stackTerm));
            if(developers != null && !developers.isEmpty())
                job.getPossibleCandidates().addAll(developers);
        }
        devRepository.saveAll(job.getPossibleCandidates());
        return repository.save(job);
    }
}
