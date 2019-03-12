package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="EMPYLOEE_ADRESS")
public class EmpyloeeAdress {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long empyloeeAdressId;
		
		@Column(name="empyloee_street", nullable=true)
		private String empyloeeStreet;
		
		@Column(name="empyloee_city", nullable=false)
		private String eppyloeeCity;
		
		@Column(name="empyloee_zip_code", nullable=false)
		private String empyloeeZipCode;
		
		protected EmpyloeeAdress() {
			
		}
		
		public EmpyloeeAdress(String empyloeeStreet, String eppyloeeCity,
				String empyloeeZipCode) {
			super();
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
