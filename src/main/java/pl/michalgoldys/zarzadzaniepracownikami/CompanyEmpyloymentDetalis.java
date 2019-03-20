package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="COMPANY_EMPYLOMENT_DETALIS")
public class CompanyEmpyloymentDetalis {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyEmploymentId;
		
		@Column(name="company_employes", nullable=false)
		private String companyEmployes;
		
		@Column(name="company_empyloes_hire_date", nullable=false)
		private String companyEmpyloesHireDate;
		
		@Column(name="company_salary_cost", nullable=false)
		private String companySalaryCost;
		
		@Autowired
		@ManyToOne
		@JoinColumn(name = "companyId")
		Company company;
		
		protected CompanyEmpyloymentDetalis() {
			
		}
		public CompanyEmpyloymentDetalis(String companyEmployes, String companyEployesHireDate,
				String companySalaryCost) {
			super();
			this.companyEmployes = companyEmployes;
			this.companyEmpyloesHireDate = companyEployesHireDate;
			this.companySalaryCost = companySalaryCost;
		}
		public String getCompanyEmployes() {
			return companyEmployes;
		}
		public void setCompanyEmployes(String companyEmployes) {
			this.companyEmployes = companyEmployes;
		}
		public String getCompanyEployesHireDate() {
			return companyEmpyloesHireDate;
		}
		public void setCompanyEployesHireDate(String companyEployesHireDate) {
			this.companyEmpyloesHireDate = companyEployesHireDate;
		}
		public String getCompanySalaryCost() {
			return companySalaryCost;
		}
		public void setCompanySalaryCost(String companySalaryCost) {
			this.companySalaryCost = companySalaryCost;
		}
	
}
