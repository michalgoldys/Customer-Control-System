package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="EMPYLOEE_EMPLOYMENT_DETALIS")
public class EmpyloeeEmploymentDetalis {

		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private long empyloeeEmploymentDetalisId;
		
		@Column(name="empyloee_salary", nullable=false)
		private Integer empyloeeSalary;
		
		@Column(name="empyloee_employment", nullable=false)
		private boolean empyloeeEpmloyment;
		
		@Column(name="empyloee_workplace", nullable=false)
		private String empyloeeWorkplace;
		
		@Autowired
		@ManyToOne
		@JoinColumn(name ="empyloeeId")
		Empyloee empyloee;
		
		protected EmpyloeeEmploymentDetalis() {
			
		}
		
		public EmpyloeeEmploymentDetalis(Integer empyloeeSalary, boolean empyloeeEpmloyment, String empyloeeWorkplace) {
			super();
			this.empyloeeSalary = empyloeeSalary;
			this.empyloeeEpmloyment = empyloeeEpmloyment;
			this.empyloeeWorkplace = empyloeeWorkplace;
		}

		public Integer getEmpyloeeSalary() {
			return empyloeeSalary;
		}

		public void setEmpyloeeSalary(Integer empyloeeSalary) {
			this.empyloeeSalary = empyloeeSalary;
		}

		public boolean isEmpyloeeEpmloyment() {
			return empyloeeEpmloyment;
		}

		public void setEmpyloeeEpmloyment(boolean empyloeeEpmloyment) {
			this.empyloeeEpmloyment = empyloeeEpmloyment;
		}

		public String getEmpyloeeWorkplace() {
			return empyloeeWorkplace;
		}

		public void setEmpyloeeWorkplace(String empyloeeWorkplace) {
			this.empyloeeWorkplace = empyloeeWorkplace;
		}
		
		
		
}
