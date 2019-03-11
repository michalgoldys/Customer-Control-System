package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empyloee {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long empyloeeId;
		
		private String empyloeeName;
		private String empyloeeSurename;
		private String empyloeeBirthDate;
		private String empyloeeTelephoneNumber;
		
		public EmpyloeeAdress epyloeeAdress;
		public EmploymentDetalis empyloeeDetalis;
		
		protected Empyloee() {
			
		}
		
		public Empyloee(String empyloeeName, String empyloeeSurename, String empyloeeBirthDate,
				String empyloeeTelephoneNumber, EmpyloeeAdress epyloeeAdress, EmploymentDetalis empyloeeDetalis) {
			super();
			this.empyloeeName = empyloeeName;
			this.empyloeeSurename = empyloeeSurename;
			this.empyloeeBirthDate = empyloeeBirthDate;
			this.empyloeeTelephoneNumber = empyloeeTelephoneNumber;
			this.epyloeeAdress = epyloeeAdress;
			this.empyloeeDetalis = empyloeeDetalis;
		}
		public String getEmpyloeeTelephoneNumber() {
			return empyloeeTelephoneNumber;
		}
		public void setEmpyloeeTelephoneNumber(String empyloeeTelephoneNumber) {
			this.empyloeeTelephoneNumber = empyloeeTelephoneNumber;
		}
		public String getEmpyloeeName() {
			return empyloeeName;
		}
		public void setEmpyloeeName(String empyloeeName) {
			this.empyloeeName = empyloeeName;
		}
		public String getEmpyloeeSurename() {
			return empyloeeSurename;
		}
		public void setEmpyloeeSurename(String empyloeeSurename) {
			this.empyloeeSurename = empyloeeSurename;
		}
		public String getEmpyloeeBirthDate() {
			return empyloeeBirthDate;
		}
		public void setEmpyloeeBirthDate(String empyloeeBirthDate) {
			this.empyloeeBirthDate = empyloeeBirthDate;
		}
		
}
