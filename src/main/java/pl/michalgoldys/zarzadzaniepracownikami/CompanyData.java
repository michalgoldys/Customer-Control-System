package pl.michalgoldys.zarzadzaniepracownikami;

public class CompanyData {

		private String companyDataId;
		private String companyName;
		private String companyNip;
		private String companyEmploymentDetalis;
		private String companyStartUpDate;
		private String companyForm;
		
		public CompanyData(String companyDataId, String companyName, String companyNip, String companyEmploymentDetalis,
				String companyStartUpDate, String companyForm) {
			super();
			this.companyDataId = companyDataId;
			this.companyName = companyName;
			this.companyNip = companyNip;
			this.companyEmploymentDetalis = companyEmploymentDetalis;
			this.companyStartUpDate = companyStartUpDate;
			this.companyForm = companyForm;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyNip() {
			return companyNip;
		}
		public void setCompanyNip(String companyNip) {
			this.companyNip = companyNip;
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
