package com.praveen.JobSphere.service;

import com.praveen.JobSphere.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    List<Job> jobs = new ArrayList<>();
    Long nextId = 1L;

    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {
        for (Job currentJob : jobs) {
            if (currentJob.getId() == id)
                return currentJob;
        }
        return null;
    }

    @Override
    public Job createJob(Job newJob) {
        if(newJob != null){
            newJob.setId(nextId ++);
            jobs.add(newJob);
//            return newJob;
        }
//        else
//            return null;

        return newJob;

    }

    @Override
    public Job updateJobById(Long id, Job updatedJob) {
        for(Job currentJob : jobs){
            if(currentJob.getId() == id){
                currentJob.setTitle(updatedJob.getTitle());
                currentJob.setDescription(updatedJob.getDescription());
                currentJob.setMinSalary(updatedJob.getMinSalary());
                currentJob.setMaxSalary(updatedJob.getMaxSalary());
                currentJob.setLocation(updatedJob.getLocation());
                currentJob.setCompany(updatedJob.getCompany());

                return currentJob;
            }
        }

        return null;
    }

    @Override
    public String getCompanyByJobId(Long id) {
        for (Job currentJob : jobs) {
            if (currentJob.getId() == id)
                return currentJob.getCompany();
        }
        return null;
    }

    @Override
    public Job deleteJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                jobs.remove(job);
                return job;
            }
        }
        return null;
    }
}
