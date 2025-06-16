package com.praveen.JobSphere.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job {
    Long id;
    String title;
    String description;
    int minSalary;
    int maxSalary;
    String location;
    String company;


}
