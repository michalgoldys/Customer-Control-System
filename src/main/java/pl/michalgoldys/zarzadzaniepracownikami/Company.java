package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long companyId;
		
		private String companyName;
		private String companyNip;

		protected Company() {
			
		}
		
		public Company(String companyName, String companyNip) {
			super();
			this.companyName = companyName;
			this.companyNip = companyNip;
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
}
