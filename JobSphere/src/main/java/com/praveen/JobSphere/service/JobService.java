package com.praveen.JobSphere.service;

import com.praveen.JobSphere.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(Long id);
    Job createJob(Job newJob);
    Job updateJobById(Long id, Job updatedJob);
    String getCompanyByJobId(Long id);
    Job deleteJobById(Long id);
}
