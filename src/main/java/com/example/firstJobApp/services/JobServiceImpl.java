package com.example.firstJobApp.services;

import com.example.firstJobApp.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAllJobs() {
        return jobs;
   }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
