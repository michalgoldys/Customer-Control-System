package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="EMPYLOYMENT_DETALIS")
public class EmploymentDetalis {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long employementDetalisId;
		
		@Column(name="empyloee_salary", nullable=false)
		private Integer emploeeSalary;
		
		@Column(name="empyloee_employment", nullable=false)
		private boolean emploeeEpmloyment;
		
		@Column(name="empyloee_workplace", nullable=false)
		private String emploeeWorkplace;
		
		protected EmploymentDetalis() {
			
		}
		
		public EmploymentDetalis(Integer emploeeSalary, boolean emploeeEpmloyment,
				String emploeeWorkplace) {
			super();
			this.emploeeSalary = emploeeSalary;
			this.emploeeEpmloyment = emploeeEpmloyment;
			this.emploeeWorkplace = emploeeWorkplace;
		}
		public float getEmploeeSalary() {
			return emploeeSalary;
		}
		public void setEmploeeSalary(Integer emploeeSalary) {
			this.emploeeSalary = emploeeSalary;
		}
		public boolean getEmploeeEpmloyment() {
			return emploeeEpmloyment;
		}
		public void setEmploeeEpmloyment(boolean emploeeEpmloyment) {
			this.emploeeEpmloyment = emploeeEpmloyment;
		}
		public String getEmploeeWorkplace() {
			return emploeeWorkplace;
		}
		public void setEmploeeWorkplace(String emploeeWorkplace) {
			this.emploeeWorkplace = emploeeWorkplace;
		}
		
}
