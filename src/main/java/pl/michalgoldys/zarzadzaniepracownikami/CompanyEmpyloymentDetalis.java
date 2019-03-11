package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyEmpyloymentDetalis {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyEmploymentId;
		
		private String companyEmployes;
		private String companyEployesHireDate;
		private String companySalaryCost;
		
		protected CompanyEmpyloymentDetalis() {
			
		}
		public CompanyEmpyloymentDetalis(String companyEmployes, String companyEployesHireDate,
				String companySalaryCost) {
			super();
			this.companyEmployes = companyEmployes;
			this.companyEployesHireDate = companyEployesHireDate;
			this.companySalaryCost = companySalaryCost;
		}
		public String getCompanyEmployes() {
			return companyEmployes;
		}
		public void setCompanyEmployes(String companyEmployes) {
			this.companyEmployes = companyEmployes;
		}
		public String getCompanyEployesHireDate() {
			return companyEployesHireDate;
		}
		public void setCompanyEployesHireDate(String companyEployesHireDate) {
			this.companyEployesHireDate = companyEployesHireDate;
		}
		public String getCompanySalaryCost() {
			return companySalaryCost;
		}
		public void setCompanySalaryCost(String companySalaryCost) {
			this.companySalaryCost = companySalaryCost;
		}
	
}
