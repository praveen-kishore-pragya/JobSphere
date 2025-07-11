package com.praveen.JobSphere.company.controller;

import com.praveen.JobSphere.company.entity.Company;
import com.praveen.JobSphere.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    private final CompanyService companyService;
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<?> getAllCompanies(){
        List<Company> allCompanies = companyService.getAllCompanies();
        if(!allCompanies.isEmpty()){
            return new ResponseEntity<>(allCompanies, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No records yet!", HttpStatusCode.valueOf(204));
        }
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id){
        Company fetchedCompany = companyService.getCompanyById(id);
        if(fetchedCompany != null){
            return new ResponseEntity<>(fetchedCompany, HttpStatus.OK);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/companies")
    public ResponseEntity<?> createCompany(@RequestBody Company newCompany){
        Company createdCompany = companyService.createCompany(newCompany);
        if(createdCompany != null){
            return ResponseEntity.ok(createdCompany);
        }
        else{
            return ResponseEntity.ok(createdCompany);
        }
    }

    @PutMapping("/companies/updateCompany/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody Company updatedCompany){
        Company refreshedCompany = companyService.updateCompany(id, updatedCompany);
        if(refreshedCompany != null){
            return ResponseEntity.ok(refreshedCompany);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/companies/deleteCompany/{id}")
    public ResponseEntity<?> deleteCompanyById(@PathVariable Long id){
        boolean isCompanyDeleted = companyService.deleteJobById(id);
        if(isCompanyDeleted){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }


}
