package com.example.firstJobApp.controller;

import com.example.firstJobApp.entity.Job;
import com.example.firstJobApp.services.JobService;
import com.example.firstJobApp.services.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*

GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by Id
POST /jobs/{id}: Create a new Job (request body should contain the job details)
DELETE /jobs/{id}: Delete a specific job by id
PUT /jobs/{id}: Update a specific job by id (request body should contain the updated job)
GET /jobs/{id}/company: Get the company associated with the job by id

Example API URLs
Get {base_URL}/jobs
GET {base_URL}/jobs/1
POST {base_URL}/jobs
DELETE {base_URL}/jobs/1
PUT {base_URL}/jobs/1
GET {base_URL}/jobs/1/company
*/

@RestController
public class JobController {
//    private List<Job> jobs = new ArrayList<>();

    //We need to initialise this jobService. So, we will be making a constructor and then initialising it.
    private JobService jobService;

    //It will initialise the jobservice on the fly.
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
//        return jobs;
        return jobService.findAllJobs();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
//        jobs.add(job);
        jobService.createJob(job);
        return "Job Added Successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return job;
        }
        return new Job(18, "Test Engineer", "Test Engineer required", 18000, 25000, "Gurugram");
    }

}
