package com.praveen.JobSphere.job.service;

import com.praveen.JobSphere.job.entity.Job;
import com.praveen.JobSphere.job.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

//    List<Job> jobs = new ArrayList<>();
//    Long nextId = 1L;

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job createJob(Job newJob) {
        return jobRepository.save(newJob);
    }

    @Override
    public Job updateJobById(Long id, Job updatedJob) {
        Optional<Job> current = jobRepository.findById(id);
        if(current.isPresent()){
            Job currentJob = current.get();
            currentJob.setTitle(updatedJob.getTitle());
            currentJob.setDescription(updatedJob.getDescription());
            currentJob.setMinSalary(updatedJob.getMinSalary());
            currentJob.setMaxSalary(updatedJob.getMaxSalary());
            currentJob.setLocation(updatedJob.getLocation());

            return jobRepository.save(currentJob);
        }

        return null;

    }

//    @Override
//    public String getCompanyByJobId(Long id) {
//        Optional<Job> current =  jobRepository.findById(id);
//        if(current.isPresent()){
//            return current.get().getCompany();
//        }
//        return null;
//
//        //OR, return current.map(Job::getCompany).orElse(null);
//    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
