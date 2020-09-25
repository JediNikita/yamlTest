package com.yodaplus.yamltest.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FinancialStatement
 */
@Validated

public class FinancialStatement   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("totalAssets")
  private BigDecimal totalAssets = null;

  @JsonProperty("netIncome")
  private BigDecimal netIncome = null;

  @JsonProperty("totalEquity")
  private BigDecimal totalEquity = null;

  @JsonProperty("annualRevenue")
  private BigDecimal annualRevenue = null;

  @JsonProperty("companyId")
  private Long companyId = null;

  @JsonProperty("PD")
  private BigDecimal PD = null;

  @JsonProperty("year")
  private String year = null;

  public FinancialStatement id(Long id) {
    this.id = id;
    return this;
  }

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FinancialStatement totalAssets(BigDecimal totalAssets) {
    this.totalAssets = totalAssets;
    return this;
  }

  @Valid

  public BigDecimal getTotalAssets() {
    return totalAssets;
  }

  public void setTotalAssets(BigDecimal totalAssets) {
    this.totalAssets = totalAssets;
  }

  public FinancialStatement netIncome(BigDecimal netIncome) {
    this.netIncome = netIncome;
    return this;
  }

  @Valid

  public BigDecimal getNetIncome() {
    return netIncome;
  }

  public void setNetIncome(BigDecimal netIncome) {
    this.netIncome = netIncome;
  }

  public FinancialStatement totalEquity(BigDecimal totalEquity) {
    this.totalEquity = totalEquity;
    return this;
  }
  
  @Valid

  public BigDecimal getTotalEquity() {
    return totalEquity;
  }

  public void setTotalEquity(BigDecimal totalEquity) {
    this.totalEquity = totalEquity;
  }

  public FinancialStatement annualRevenue(BigDecimal annualRevenue) {
    this.annualRevenue = annualRevenue;
    return this;
  }

  @Valid

  public BigDecimal getAnnualRevenue() {
    return annualRevenue;
  }

  public void setAnnualRevenue(BigDecimal annualRevenue) {
    this.annualRevenue = annualRevenue;
  }

  public FinancialStatement companyId(Long companyId) {
    this.companyId = companyId;
    return this;
  }


  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public FinancialStatement PD(BigDecimal PD) {
    this.PD = PD;
    return this;
  }


  @Valid

  public BigDecimal getPD() {
    return PD;
  }

  public void setPD(BigDecimal PD) {
    this.PD = PD;
  }

  public FinancialStatement year(String year) {
    this.year = year;
    return this;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialStatement financialStatement = (FinancialStatement) o;
    return Objects.equals(this.id, financialStatement.id) &&
        Objects.equals(this.totalAssets, financialStatement.totalAssets) &&
        Objects.equals(this.netIncome, financialStatement.netIncome) &&
        Objects.equals(this.totalEquity, financialStatement.totalEquity) &&
        Objects.equals(this.annualRevenue, financialStatement.annualRevenue) &&
        Objects.equals(this.companyId, financialStatement.companyId) &&
        Objects.equals(this.PD, financialStatement.PD) &&
        Objects.equals(this.year, financialStatement.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, totalAssets, netIncome, totalEquity, annualRevenue, companyId, PD, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialStatement {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    totalAssets: ").append(toIndentedString(totalAssets)).append("\n");
    sb.append("    netIncome: ").append(toIndentedString(netIncome)).append("\n");
    sb.append("    totalEquity: ").append(toIndentedString(totalEquity)).append("\n");
    sb.append("    annualRevenue: ").append(toIndentedString(annualRevenue)).append("\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    PD: ").append(toIndentedString(PD)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


