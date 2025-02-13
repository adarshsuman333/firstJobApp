package com.example.firstJobApp.services;

import com.example.firstJobApp.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAllJobs();
    void createJob(Job job);

    Job getJobById(Long id);
}
