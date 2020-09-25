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
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.yodaplus.yamltest.model.Company;
import com.yodaplus.yamltest.service.CompaniesApiService;

@RestController
public class CompaniesApiController implements CompaniesApi {
	ConcurrentMap<String, Company> companyMap= new ConcurrentHashMap<>(); 

	private static final Logger log = LoggerFactory.getLogger(CompaniesApiController.class);
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;


	@Autowired
	private CompaniesApiService cas;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired 
	Environment env;

	@Autowired
	public CompaniesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@RequestMapping(value="/", method= RequestMethod.GET)
	public ResponseEntity<Void> showHello(){
		System.out.println(companyMap.values());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> addCompany(@Valid Company body) {
		companyMap.put(body.getId().toString(), body);
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS company (\r\n" + 
				"    ID                 INTEGER       ,\r\n" + 
				"    COMPANYNAME        VARCHAR (100),\r\n" + 
				"    DOMICILECOUNTRYISO VARCHAR (50),\r\n" + 
				"    COMPANYTYPE        VARCHAR (50),\r\n" + 
				"    ORGUNIQUEID        INTEGER,\r\n" + 
				"    PORTFOLIO          VARCHAR (50),\r\n" + 
				"    UNIQUEID           INTEGER\r\n" + 
				");");
		String sql = "INSERT INTO COMPANY (ID,COMPANYNAME,COMPANYTYPE,DOMICILECOUNTRYISO,ORGUNIQUEID, PORTFOLIO, UNIQUEID) VALUES (?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql, body.getId(), body.getCompanyName(), body.getCompanyType(), body.getDomicileCountryISO(), body.getOrgUniqueId(),
				body.getPortfolio(), body.getUniqueId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCompany(Long companyId, String apiKey) {
		companyMap.remove(companyId.toString());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Company>> findCompaniessByParams( @NotNull @Valid String portfolio, @Valid Boolean isPDExpired) {
		List<Company> companyList= new ArrayList<>();
		companyList= cas.getCompanyListByParams(companyMap, portfolio, isPDExpired);
		/* companyList= jdbcTemplate.query*/
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/xml")) {
			try {
				return new ResponseEntity<List<Company>>(objectMapper.readValue(new XStream().toXML(companyList), new TypeReference<List<Company>>() {
				}) , HttpStatus.OK) ;
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/xml", e);
				return new ResponseEntity<List<Company>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Company>>(objectMapper.readValue(new Gson().toJson(companyList), new TypeReference<List<Company>>() {
				}) , HttpStatus.OK) ;
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Company>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<List<Company>>(companyList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Company> getCompanyById(Long companyId) {
		String accept = request.getHeader("Accept");
		Company comp= cas.getCompanyById(companyMap, companyId);
		if(comp==null)
			return new ResponseEntity<Company>(HttpStatus.NOT_IMPLEMENTED);
		else {
			if (accept != null && accept.contains("application/xml")) {
				try {
					return new ResponseEntity<Company>(objectMapper.readValue(new XStream().toXML(comp), Company.class), HttpStatus.OK);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/xml", e);
					return new ResponseEntity<Company>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			if (accept != null && accept.contains("application/json")) {
				try {
					return new ResponseEntity<Company>(objectMapper.readValue(new Gson().toJson(comp), Company.class), HttpStatus.OK);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<Company>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		}
		return new ResponseEntity<Company>(HttpStatus.NOT_IMPLEMENTED);
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
