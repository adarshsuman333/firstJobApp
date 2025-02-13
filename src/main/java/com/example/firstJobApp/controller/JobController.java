package com.example.firstJobApp.controller;

import com.example.firstJobApp.entity.Job;
import com.example.firstJobApp.services.JobService;
import com.example.firstJobApp.services.JobServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/jobs")
public class JobController {
//    private List<Job> jobs = new ArrayList<>();

    //We need to initialise this jobService. So, we will be making a constructor and then initialising it.
    private JobService jobService;

    //It will initialise the jobservice on the fly.
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>>  findAll(){
//        return jobs;
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping
    public ResponseEntity<String>  createJob(@RequestBody Job job){
//        jobs.add(job);
        jobService.createJob(job);
        return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted){
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
