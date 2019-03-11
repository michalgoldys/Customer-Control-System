package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyAdress {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyID;
		
		private String companyStreet;
		private String companyCity;
		private String companyCountry;
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
