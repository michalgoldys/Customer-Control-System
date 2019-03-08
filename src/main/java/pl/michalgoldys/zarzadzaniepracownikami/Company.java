package pl.michalgoldys.zarzadzaniepracownikami;

public class Company {

		public CompanyData companydata;
		public CompanyAdress companyadress;
		
		public Company(CompanyData companydata, CompanyAdress companyadress) {
			super();
			this.companydata = companydata;
			this.companyadress = companyadress;
		}
		
}
