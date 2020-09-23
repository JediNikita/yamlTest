package com.yodaplus.yamltest.service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.yodaplus.yamltest.model.Company;

@Service
public interface CompaniesApiService {

	public List<Company> getCompanyListByParams(ConcurrentMap<String, Company> companyMap, @NotNull @Valid String portfolio,
			@Valid Boolean isPDExpired);
	
	public Company getCompanyById(ConcurrentMap<String, Company> companyMap,Long companyId) ;
}
