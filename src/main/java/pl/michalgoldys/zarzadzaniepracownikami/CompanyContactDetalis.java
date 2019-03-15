package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="COMPANY_CONTACT_DETALIS")
public class CompanyContactDetalis {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long companyContactDetalisId;
	
		@Column(name="company_contact_number", nullable=false)
		private String companyContactNumber;
		
		@Column(name="company_main_contact_number", nullable=false)
		private String companyMainContactNumber;
		
		@Column(name="company_email_adress", nullable=false)
		private String companyEmailAdress;

		protected CompanyContactDetalis() {
			
		}
		
		public CompanyContactDetalis(String companyContactNumber, String companyMainContactNumber,
				String companyEmailAdress) {
			super();
			this.companyContactNumber = companyContactNumber;
			this.companyMainContactNumber = companyMainContactNumber;
			this.companyEmailAdress = companyEmailAdress;
		}

		public String getCompanyContactNumber() {
			return companyContactNumber;
		}

		public void setCompanyContactNumber(String companyContactNumber) {
			this.companyContactNumber = companyContactNumber;
		}

		public String getCompanyMainContactNumber() {
			return companyMainContactNumber;
		}

		public void setCompanyMainContactNumber(String companyMainContactNumber) {
			this.companyMainContactNumber = companyMainContactNumber;
		}

		public String getCompanyEmailAdress() {
			return companyEmailAdress;
		}

		public void setCompanyEmailAdress(String companyEmailAdress) {
			this.companyEmailAdress = companyEmailAdress;
		}
		
		
		
}
