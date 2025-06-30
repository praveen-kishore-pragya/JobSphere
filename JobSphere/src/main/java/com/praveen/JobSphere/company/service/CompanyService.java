package com.praveen.JobSphere.company.service;

import com.praveen.JobSphere.company.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company newCompany);

    Company updateCompany(Long id, Company updatedCompany);
}
