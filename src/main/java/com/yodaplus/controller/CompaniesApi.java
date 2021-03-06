package com.yodaplus.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yodaplus.yamltest.model.Company;
@Validated

public interface CompaniesApi {
    
    @RequestMapping(value = "/companies",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addCompany( @Valid @RequestBody Company body);


    
    @RequestMapping(value = "/companies/{companyId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCompany( @PathVariable("companyId") Long companyId, @RequestHeader(value="api_key", required=false) String apiKey);


   
    @RequestMapping(value = "/companies/findByParams",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Company>> findCompaniessByParams(@NotNull  @Valid @RequestParam(value = "portfolio", required = true, defaultValue="active") String portfolio,@NotNull  @Valid @RequestParam(value = "isPDExpired", required = true, defaultValue="true") Boolean isPDExpired);


    
    @RequestMapping(value = "/companies/{companyId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Company> getCompanyById( @PathVariable("companyId") Long companyId);


    
    @RequestMapping(value = "/companies",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Company>> getCompanyList();


    
	/*
	 * @RequestMapping(value = "/companies/{companyId}/financial-statements/{year}",
	 * produces = { "application/xml", "application/json" }, method =
	 * RequestMethod.GET) ResponseEntity<FinancialStatement>
	 * getFinancialStatementByYear( @PathVariable("companyId") Long
	 * companyId, @PathVariable("year") Long year);
	 */

    @RequestMapping(value = "/companies/{companyId}",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<Void> partialUpdateCompany( @PathVariable("companyId") Long companyId,  @Valid @RequestBody Company body);


   
    @RequestMapping(value = "/companies",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCompany(  @Valid @RequestBody Company body);

}

