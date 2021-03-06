package com.yodaplus.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodaplus.yamltest.model.Facility;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-17T05:30:30.601Z")

@Controller
public class FacilitiesApiController implements FacilitiesApi {

    private static final Logger log = LoggerFactory.getLogger(FacilitiesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FacilitiesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
	public ResponseEntity<Facility> findFacilityRatingByIdAndPeriod(@ApiParam(value = "FacilityId",required=true) @PathVariable("facilityId") String facilityId,@NotNull @ApiParam(value = "Effective period in yyyymm format", required = true) @Valid @RequestParam(value = "periodo", required = true) String periodo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Facility>(objectMapper.readValue("<Facility>  <id>123456789</id>  <expectedLossDefault>1.3579</expectedLossDefault>  <finalRating>aeiou</finalRating>  <expectedLossGrade>1.3579</expectedLossGrade>  <ratingDate>2000-01-23</ratingDate>  <yyyymm>aeiou</yyyymm></Facility>", Facility.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Facility>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Facility>(objectMapper.readValue("{  \"expectedLossDefault\" : 6.02745618307040320615897144307382404804229736328125,  \"finalRating\" : \"A\",  \"ratingDate\" : \"2000-01-23\",  \"id\" : 0,  \"yyyymm\" : \"yyyymm\",  \"expectedLossGrade\" : 1.46581298050294517310021547018550336360931396484375}", Facility.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Facility>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Facility>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<List<Facility>> findFacilityRatingsByPeriod(@NotNull @ApiParam(value = "Effective period in yyyymm format", required = true) @Valid @RequestParam(value = "periodo", required = true) String periodo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<List<Facility>>(objectMapper.readValue("<Facility>  <id>123456789</id>  <expectedLossDefault>1.3579</expectedLossDefault>  <finalRating>aeiou</finalRating>  <expectedLossGrade>1.3579</expectedLossGrade>  <ratingDate>2000-01-23</ratingDate>  <yyyymm>aeiou</yyyymm></Facility>", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<List<Facility>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Facility>>(objectMapper.readValue("[ {  \"expectedLossDefault\" : 6.02745618307040320615897144307382404804229736328125,  \"finalRating\" : \"A\",  \"ratingDate\" : \"2000-01-23\",  \"id\" : 0,  \"yyyymm\" : \"yyyymm\",  \"expectedLossGrade\" : 1.46581298050294517310021547018550336360931396484375}, {  \"expectedLossDefault\" : 6.02745618307040320615897144307382404804229736328125,  \"finalRating\" : \"A\",  \"ratingDate\" : \"2000-01-23\",  \"id\" : 0,  \"yyyymm\" : \"yyyymm\",  \"expectedLossGrade\" : 1.46581298050294517310021547018550336360931396484375} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Facility>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Facility>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<List<Facility>> getFacilityRatings() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Facility>>(objectMapper.readValue("[ {  \"expectedLossDefault\" : 6.02745618307040320615897144307382404804229736328125,  \"finalRating\" : \"A\",  \"ratingDate\" : \"2000-01-23\",  \"id\" : 0,  \"yyyymm\" : \"yyyymm\",  \"expectedLossGrade\" : 1.46581298050294517310021547018550336360931396484375}, {  \"expectedLossDefault\" : 6.02745618307040320615897144307382404804229736328125,  \"finalRating\" : \"A\",  \"ratingDate\" : \"2000-01-23\",  \"id\" : 0,  \"yyyymm\" : \"yyyymm\",  \"expectedLossGrade\" : 1.46581298050294517310021547018550336360931396484375} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Facility>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Facility>>(HttpStatus.NOT_IMPLEMENTED);
    }

}