package com.yodaplus.yamltest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.yodaplus.yamltest.model.Company;

@Service
public class CompaniesApiService {

	public List<Company> getCompanyList(ConcurrentMap<String, Company> companyMap, @NotNull @Valid String portfolio,
			@Valid Boolean isPDExpired) {

		List<Company> companyList= new ArrayList<>();
		for(Company company: companyMap.values()) {
			if(company.getPortfolio().toString().equals(portfolio) && isPDExpired==true) {
				companyList.add(company);
			}
		}
		return companyList;
	}

}
