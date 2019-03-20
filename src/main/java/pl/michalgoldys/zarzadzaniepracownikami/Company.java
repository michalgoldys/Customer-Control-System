package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="COMPANY")
public class Company {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyId;
		
		@Column(name="company_name", nullable=false)
		private String companyName;
		
		@Column(name="company_nip", nullable=false)
		private String companyNip;

		@Column(name="company_is_active")
		private boolean companyIsActive;
		
		@Autowired
		@OneToMany
		CompanyAdress companyAdress;
		
		@Autowired
		@OneToMany
		CompanyContactDetalis companyContactDetalis;
		
		@Autowired
		@OneToMany
		CompanyData companyData;
		
		@Autowired
		@OneToMany
		CompanyEmpyloymentDetalis companyEmpyloymentDetalis;
		
		protected Company() {
			
		}
		
		public Company(String companyName, String companyNip, boolean companyIsActive) {
			super();
			this.companyName = companyName;
			this.companyNip = companyNip;
			this.companyIsActive = companyIsActive;
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

		public boolean isCompanyIsActive() {
			return companyIsActive;
		}

		public void setCompanyIsActive(boolean companyIsActive) {
			this.companyIsActive = companyIsActive;
		}
}
