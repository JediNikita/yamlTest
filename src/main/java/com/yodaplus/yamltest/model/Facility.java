package com.yodaplus.yamltest.model;


import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


@Validated

public class Facility   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("expectedLossDefault")
  private BigDecimal expectedLossDefault = null;

  @JsonProperty("finalRating")
  private String finalRating = "A";

  @JsonProperty("expectedLossGrade")
  private BigDecimal expectedLossGrade = null;

  @JsonProperty("ratingDate")
  private LocalDate ratingDate = null;

  @JsonProperty("yyyymm")
  private String yyyymm = null;

  public Facility id(Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Facility expectedLossDefault(BigDecimal expectedLossDefault) {
    this.expectedLossDefault = expectedLossDefault;
    return this;
  }

  @Valid

  public BigDecimal getExpectedLossDefault() {
    return expectedLossDefault;
  }

  public void setExpectedLossDefault(BigDecimal expectedLossDefault) {
    this.expectedLossDefault = expectedLossDefault;
  }

  public Facility finalRating(String finalRating) {
    this.finalRating = finalRating;
    return this;
  }

  
  public String getFinalRating() {
    return finalRating;
  }

  public void setFinalRating(String finalRating) {
    this.finalRating = finalRating;
  }

  public Facility expectedLossGrade(BigDecimal expectedLossGrade) {
    this.expectedLossGrade = expectedLossGrade;
    return this;
  }

 
  @Valid

  public BigDecimal getExpectedLossGrade() {
    return expectedLossGrade;
  }

  public void setExpectedLossGrade(BigDecimal expectedLossGrade) {
    this.expectedLossGrade = expectedLossGrade;
  }

  public Facility ratingDate(LocalDate ratingDate) {
    this.ratingDate = ratingDate;
    return this;
  }

  @Valid

  public LocalDate getRatingDate() {
    return ratingDate;
  }

  public void setRatingDate(LocalDate ratingDate) {
    this.ratingDate = ratingDate;
  }

  public Facility yyyymm(String yyyymm) {
    this.yyyymm = yyyymm;
    return this;
  }

 
  public String getYyyymm() {
    return yyyymm;
  }

  public void setYyyymm(String yyyymm) {
    this.yyyymm = yyyymm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Facility facility = (Facility) o;
    return Objects.equals(this.id, facility.id) &&
        Objects.equals(this.expectedLossDefault, facility.expectedLossDefault) &&
        Objects.equals(this.finalRating, facility.finalRating) &&
        Objects.equals(this.expectedLossGrade, facility.expectedLossGrade) &&
        Objects.equals(this.ratingDate, facility.ratingDate) &&
        Objects.equals(this.yyyymm, facility.yyyymm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, expectedLossDefault, finalRating, expectedLossGrade, ratingDate, yyyymm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Facility {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    expectedLossDefault: ").append(toIndentedString(expectedLossDefault)).append("\n");
    sb.append("    finalRating: ").append(toIndentedString(finalRating)).append("\n");
    sb.append("    expectedLossGrade: ").append(toIndentedString(expectedLossGrade)).append("\n");
    sb.append("    ratingDate: ").append(toIndentedString(ratingDate)).append("\n");
    sb.append("    yyyymm: ").append(toIndentedString(yyyymm)).append("\n");
    sb.append("}");
    return sb.toString();
  }

 
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

