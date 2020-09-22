package com.yodaplus.yamltest.model;


import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Company
 */
@Validated
@Component
public class Company   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("orgUniqueId")
	private Long orgUniqueId = null;

	@JsonProperty("uniqueId")
	private Long uniqueId = null;

	@JsonProperty("companyName")
	private String companyName = null;

	@JsonProperty("domicileCountryISO")
	private String domicileCountryISO = null;

	@JsonProperty("companyType")
	private String companyType = null;

	/**
	 * Active/Inactive Portfolio
	 */
	public enum PortfolioEnum {
		ACTIVE("active"),

		INACTIVE("inactive");

		private String value;

		PortfolioEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static PortfolioEnum fromValue(String text) {
			for (PortfolioEnum b : PortfolioEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("portfolio")
	private PortfolioEnum portfolio = null;

	@JsonProperty("expiredPD")
	private Boolean expiredPD = false;

	public Company id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company orgUniqueId(Long orgUniqueId) {
		this.orgUniqueId = orgUniqueId;
		return this;
	}

	/**
	 * Get orgUniqueId
	 * @return orgUniqueId
	 **/


	public Long getOrgUniqueId() {
		return orgUniqueId;
	}

	public void setOrgUniqueId(Long orgUniqueId) {
		this.orgUniqueId = orgUniqueId;
	}

	public Company uniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
		return this;
	}

	/**
	 * Get uniqueId
	 * @return uniqueId
	 **/


	public Long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Company companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	/**
	 * Get companyName
	 * @return companyName
	 **/


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Company domicileCountryISO(String domicileCountryISO) {
		this.domicileCountryISO = domicileCountryISO;
		return this;
	}

	/**
	 * Get domicileCountryISO
	 * @return domicileCountryISO
	 **/


	public String getDomicileCountryISO() {
		return domicileCountryISO;
	}

	public void setDomicileCountryISO(String domicileCountryISO) {
		this.domicileCountryISO = domicileCountryISO;
	}

	public Company companyType(String companyType) {
		this.companyType = companyType;
		return this;
	}

	/**
	 * Get companyType
	 * @return companyType
	 **/


	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Company portfolio(PortfolioEnum portfolio) {
		this.portfolio = portfolio;
		return this;
	}

	/**
	 * Active/Inactive Portfolio
	 * @return portfolio
	 **/


	public PortfolioEnum getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(PortfolioEnum portfolio) {
		this.portfolio = portfolio;
	}

	public Company expiredPD(Boolean expiredPD) {
		this.expiredPD = expiredPD;
		return this;
	}

	/**
	 * Get expiredPD
	 * @return expiredPD
	 **/


	public Boolean isExpiredPD() {
		return expiredPD;
	}

	public void setExpiredPD(Boolean expiredPD) {
		this.expiredPD = expiredPD;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Company company = (Company) o;
		return Objects.equals(this.id, company.id) &&
				Objects.equals(this.orgUniqueId, company.orgUniqueId) &&
				Objects.equals(this.uniqueId, company.uniqueId) &&
				Objects.equals(this.companyName, company.companyName) &&
				Objects.equals(this.domicileCountryISO, company.domicileCountryISO) &&
				Objects.equals(this.companyType, company.companyType) &&
				Objects.equals(this.portfolio, company.portfolio) &&
				Objects.equals(this.expiredPD, company.expiredPD);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orgUniqueId, uniqueId, companyName, domicileCountryISO, companyType, portfolio, expiredPD);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Company {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    orgUniqueId: ").append(toIndentedString(orgUniqueId)).append("\n");
		sb.append("    uniqueId: ").append(toIndentedString(uniqueId)).append("\n");
		sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
		sb.append("    domicileCountryISO: ").append(toIndentedString(domicileCountryISO)).append("\n");
		sb.append("    companyType: ").append(toIndentedString(companyType)).append("\n");
		sb.append("    portfolio: ").append(toIndentedString(portfolio)).append("\n");
		sb.append("    expiredPD: ").append(toIndentedString(expiredPD)).append("\n");
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


