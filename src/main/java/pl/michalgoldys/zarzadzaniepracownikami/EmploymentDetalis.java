package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmploymentDetalis {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long employementDetalisId;
		
		private float emploeeSalary;
		private String emploeeEpmloyment;
		private String emploeeWorkplace;
		
		protected EmploymentDetalis() {
			
		}
		
		public EmploymentDetalis(float emploeeSalary, String emploeeEpmloyment,
				String emploeeWorkplace) {
			super();
			this.emploeeSalary = emploeeSalary;
			this.emploeeEpmloyment = emploeeEpmloyment;
			this.emploeeWorkplace = emploeeWorkplace;
		}
		public float getEmploeeSalary() {
			return emploeeSalary;
		}
		public void setEmploeeSalary(float emploeeSalary) {
			this.emploeeSalary = emploeeSalary;
		}
		public String getEmploeeEpmloyment() {
			return emploeeEpmloyment;
		}
		public void setEmploeeEpmloyment(String emploeeEpmloyment) {
			this.emploeeEpmloyment = emploeeEpmloyment;
		}
		public String getEmploeeWorkplace() {
			return emploeeWorkplace;
		}
		public void setEmploeeWorkplace(String emploeeWorkplace) {
			this.emploeeWorkplace = emploeeWorkplace;
		}
		
}
