package com.jobApp.firstJobApp.repository;

import com.jobApp.firstJobApp.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
