package com.jobApp.firstJobApp.services;

import com.jobApp.firstJobApp.entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Long id, Company updatedCompany);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);
}
