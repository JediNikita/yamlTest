package com.yodaplus.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yodaplus.yamltest.model.Facility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-17T05:30:30.601Z")

@Api(value = "facilities", description = "the facilities API")
@RequestMapping(value = "/v2")
public interface FacilitiesApi {

    @ApiOperation(value = "Finds facility rating by rating period", nickname = "findFacilityRatingByIdAndPeriod", notes = "Provide rating period", response = Facility.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "facility", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Facility.class),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @RequestMapping(value = "/facilities/{facilityId}/findByPeriodo",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Facility> findFacilityRatingByIdAndPeriod(@ApiParam(value = "FacilityId",required=true) @PathVariable("facilityId") String facilityId,@NotNull @ApiParam(value = "Effective period in yyyymm format", required = true) @Valid @RequestParam(value = "periodo", required = true) String periodo);


    @ApiOperation(value = "Finds facility ratings by rating period", nickname = "findFacilityRatingsByPeriod", notes = "Provide rating period", response = Facility.class, responseContainer = "List", authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "facility", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Facility.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @RequestMapping(value = "/facilities/findByPeriodo",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Facility>> findFacilityRatingsByPeriod(@NotNull @ApiParam(value = "Effective period in yyyymm format", required = true) @Valid @RequestParam(value = "periodo", required = true) String periodo);


    @ApiOperation(value = "Returns list of all facilties with ratings", nickname = "getFacilityRatings", notes = "Returns a list of facilities with ratings", response = Facility.class, responseContainer = "List", authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "facility", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Facility.class, responseContainer = "List") })
    @RequestMapping(value = "/facilities",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Facility>> getFacilityRatings();

}