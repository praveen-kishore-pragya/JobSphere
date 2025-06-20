package com.praveen.JobSphere.controller;

import com.praveen.JobSphere.entity.Job;
import com.praveen.JobSphere.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getAllJobs(){
        List<Job> allJobs = jobService.getAllJobs();
        if(!allJobs.isEmpty()){     //or, if(allJobs.size() != 0)
            return new ResponseEntity<>(allJobs, HttpStatus.OK);
        }
        return new ResponseEntity<>("No records yet", HttpStatusCode.valueOf(204));
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<?> getJobById(@PathVariable Long id){
        Job fetchedJob = jobService.getJobById(id);
        if(fetchedJob != null){
            return new ResponseEntity<>(fetchedJob, HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/jobs/newJob")
    public ResponseEntity<?> createJob(@RequestBody Job newJob){
        Job createdJob = jobService.createJob(newJob);
        if(createdJob != null){
            return new ResponseEntity<>(createdJob, HttpStatus.OK);
        }
        else{
            return ResponseEntity.ok(createdJob);
        }

    }

    @DeleteMapping("/jobs/deleteJob/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable Long id){
        Job deletedJob = jobService.deleteJobById(id);
        if(deletedJob != null){
            return ResponseEntity.ok(deletedJob);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/jobs/updateJob/{id}")
    public ResponseEntity<?> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        Job refreshedJob = jobService.updateJobById(id, updatedJob);
        if(refreshedJob != null){
            return new ResponseEntity<>(refreshedJob, HttpStatus.OK);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/jobs/getCompanyDetails/{id}")
    public ResponseEntity<?> getCompanyByJobId(@PathVariable Long id){
        String companyOfTheEmp = jobService.getCompanyByJobId(id);
        if(companyOfTheEmp != null){
            return ResponseEntity.ok(companyOfTheEmp);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
