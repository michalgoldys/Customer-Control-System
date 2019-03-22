package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="EMPYLOEE")
public class Empyloee {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long empyloeeId;
		
		@Column(name="empyloee_name", nullable=false)
		private String empyloeeName;
		
		@Column(name="empyloee_surname", nullable=false)
		private String empyloeeSurname;
		
		@Column(name="empyloee_birth_date", nullable=false)
		private String empyloeeBirthDate;
		
		@Column(name="empyloee_telephone_number", nullable=false)
		private String empyloeeTelephoneNumber;

		@Autowired
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "empyloee")
		private List<EmpyloeeAdress> empyloeeAdress;
		
		@Autowired
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "empyloee")
		private List<EmpyloeeEmploymentDetalis> empyloeeEmploymentDetalis;
		
		protected Empyloee() {
			
		}
		
		public Empyloee(String empyloeeName, String empyloeeSurename, String empyloeeBirthDate,
				String empyloeeTelephoneNumber) {
			super();
			this.empyloeeName = empyloeeName;
			this.empyloeeSurname = empyloeeSurename;
			this.empyloeeBirthDate = empyloeeBirthDate;
			this.empyloeeTelephoneNumber = empyloeeTelephoneNumber;
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
			return empyloeeSurname;
		}
		public void setEmpyloeeSurename(String empyloeeSurename) {
			this.empyloeeSurname = empyloeeSurename;
		}
		public String getEmpyloeeBirthDate() {
			return empyloeeBirthDate;
		}
		public void setEmpyloeeBirthDate(String empyloeeBirthDate) {
			this.empyloeeBirthDate = empyloeeBirthDate;
		}
		
}
