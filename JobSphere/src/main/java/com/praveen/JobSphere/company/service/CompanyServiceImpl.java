package com.praveen.JobSphere.company.service;

import com.praveen.JobSphere.company.entity.Company;
import com.praveen.JobSphere.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company newCompany) {
        if(newCompany != null)
            return companyRepository.save(newCompany);
        else
            return null;
    }

    @Override
    public Company updateCompany(Long id, Company updatedCompany) {
        Optional<Company> current = companyRepository.findById(id);
        if(current.isPresent()){
            Company currentCompany = current.get();

            currentCompany.setName(updatedCompany.getName());
            currentCompany.setDescription(updatedCompany.getDescription());
            currentCompany.setListOfJobs(updatedCompany.getListOfJobs());

            companyRepository.save(currentCompany);
        }

        return null;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
