package com.jobApp.firstJobApp.repository;

import com.jobApp.firstJobApp.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
