package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="COMPANY_DATA")
public class CompanyData {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyDataId;
		
		@Column(name="company_employment_detalis", nullable=false)
		private String companyEmploymentDetalis;
		@Column(name="company_start_up_date", nullable=false)
		private String companyStartUpDate;
		@Column(name="company_form", nullable=false)
		private String companyForm;
		@Column(name="is_active_company", nullable=false)
		private boolean isActiveCompany;
		
		protected CompanyData() {
			
		}

		public CompanyData(String companyEmploymentDetalis, String companyStartUpDate, String companyForm,
				boolean isActiveCompany) {
			super();
			this.companyEmploymentDetalis = companyEmploymentDetalis;
			this.companyStartUpDate = companyStartUpDate;
			this.companyForm = companyForm;
			this.isActiveCompany = isActiveCompany;
		}

		public boolean isActiveCompany() {
			return isActiveCompany;
		}

		public void setActiveCompany(boolean isActiveCompany) {
			this.isActiveCompany = isActiveCompany;
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
