package pl.michalgoldys.zarzadzaniepracownikami;

public class EmpyloeeAdress {

		private int empyloeeAdressid;
		private String empyloeeStreet;
		private String eppyloeeCity;
		private String empyloeeZipCode;
		
		public EmpyloeeAdress(int empyloeeAdressid, String empyloeeStreet, String eppyloeeCity,
				String empyloeeZipCode) {
			super();
			this.empyloeeAdressid = empyloeeAdressid;
			this.empyloeeStreet = empyloeeStreet;
			this.eppyloeeCity = eppyloeeCity;
			this.empyloeeZipCode = empyloeeZipCode;
		}
		public String getEmpyloeeStreet() {
			return empyloeeStreet;
		}
		public void setEmpyloeeStreet(String empyloeeStreet) {
			this.empyloeeStreet = empyloeeStreet;
		}
		public String getEppyloeeCity() {
			return eppyloeeCity;
		}
		public void setEppyloeeCity(String eppyloeeCity) {
			this.eppyloeeCity = eppyloeeCity;
		}
		public String getEmpyloeeZipCode() {
			return empyloeeZipCode;
		}
		public void setEmpyloeeZipCode(String empyloeeZipCode) {
			this.empyloeeZipCode = empyloeeZipCode;
		}
		
}
