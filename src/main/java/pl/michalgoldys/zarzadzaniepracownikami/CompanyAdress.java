package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="COMPANY_ADRESS")
public class CompanyAdress {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyAdressId;
		
		@Column(name="company_street", nullable=false)
		private String companyStreet;
		
		@Column(name="company_city", nullable=false)
		private String companyCity;
		
		@Column(name="company_country", nullable=false)
		private String companyCountry;
		
		@Column(name="company_zip_code", nullable=false)
		private String companyZipCode;
		
		protected CompanyAdress() {
			
		}
		
		public CompanyAdress(String companyStreet, String companyCity, String companyCountry,
				String companyZipCode) {
			super();
			this.companyStreet = companyStreet;
			this.companyCity = companyCity;
			this.companyCountry = companyCountry;
			this.companyZipCode = companyZipCode;
		}
		public String getCompanyStreet() {
			return companyStreet;
		}
		public void setCompanyStreet(String companyStreet) {
			this.companyStreet = companyStreet;
		}
		public String getCompanyCity() {
			return companyCity;
		}
		public void setCompanyCity(String companyCity) {
			this.companyCity = companyCity;
		}
		public String getCompanyCountry() {
			return companyCountry;
		}
		public void setCompanyCountry(String companyCountry) {
			this.companyCountry = companyCountry;
		}
		public String getCompanyZipCode() {
			return companyZipCode;
		}
		public void setCompanyZipCode(String companyZipCode) {
			this.companyZipCode = companyZipCode;
		}
}
