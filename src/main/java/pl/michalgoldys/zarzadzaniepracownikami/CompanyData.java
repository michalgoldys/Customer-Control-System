package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CompanyData {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyDataId;
	
		private String companyEmploymentDetalis;
		private String companyStartUpDate;
		private String companyForm;
		
		protected CompanyData() {
			
		}
		
		public CompanyData(String companyEmploymentDetalis,
				String companyStartUpDate, String companyForm) {
			super();
			this.companyEmploymentDetalis = companyEmploymentDetalis;
			this.companyStartUpDate = companyStartUpDate;
			this.companyForm = companyForm;
		}

		public String getCompanyEmploymentDetalis() {
			return companyEmploymentDetalis;
		}
		public void setCompanyEmploymentDetalis(String companyEmploymentDetalis) {
			this.companyEmploymentDetalis = companyEmploymentDetalis;
		}
		public String getCompanyStartUpDate() {
			return companyStartUpDate;
		}
		public void setCompanyStartUpDate(String companyStartUpDate) {
			this.companyStartUpDate = companyStartUpDate;
		}
		public String getCompanyForm() {
			return companyForm;
		}
		public void setCompanyForm(String companyForm) {
			this.companyForm = companyForm;
		}
	
}
