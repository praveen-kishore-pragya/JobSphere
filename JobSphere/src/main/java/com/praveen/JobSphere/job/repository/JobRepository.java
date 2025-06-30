package com.praveen.JobSphere.job.repository;

import com.praveen.JobSphere.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{

}
