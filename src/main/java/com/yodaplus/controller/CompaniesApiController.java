package com.yodaplus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodaplus.yamltest.model.Company;
import com.yodaplus.yamltest.service.CompaniesApiService;

@RestController
public class CompaniesApiController implements CompaniesApi {
	ConcurrentMap<String, Company> companyMap= new ConcurrentHashMap<>(); 

	private static final Logger log = LoggerFactory.getLogger(CompaniesApiController.class);
	private final ObjectMapper objectMapper=null;



	@Autowired
	private CompaniesApiService cas;

	@RequestMapping(value="/", method= RequestMethod.GET)
	public ResponseEntity<Void> showHello(){
		System.out.println(companyMap.values());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> addCompany(@Valid Company body) {
		companyMap.put(body.getId().toString(), body);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCompany(Long companyId, String apiKey) {
		companyMap.remove(companyId.toString());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Company>> findCompaniessByParams(HttpServletRequest request, @NotNull @Valid String portfolio, @Valid Boolean isPDExpired) {
		List<Company> companyList= new ArrayList<>();
		companyList= cas.getCompanyList(companyMap, portfolio, isPDExpired);
		
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/xml")) {
			try {
				return new ResponseEntity<List<Company>>(objectMapper.readValue(objectMapper.writeValueAsString(companyList), List.class) , HttpStatus.NOT_IMPLEMENTED) ;
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/xml", e);
				return new ResponseEntity<List<Company>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Company>>(objectMapper.readValue(objectMapper.writeValueAsString(companyList), List.class), HttpStatus.NOT_IMPLEMENTED) ;
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Company>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<List<Company>>(companyList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Company> getCompanyById(Long companyId) {
		return null;
	}

	@Override
	public ResponseEntity<List<Company>> getCompanyList() {
		return null;
	}

	@Override
	public ResponseEntity<Void> partialUpdateCompany(Long companyId, @Valid Company body) {
		return null;
	}

	@Override
	public ResponseEntity<Void> updateCompany(@Valid Company body) {
		return null;
	}

}