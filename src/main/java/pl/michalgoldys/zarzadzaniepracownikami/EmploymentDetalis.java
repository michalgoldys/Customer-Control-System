package pl.michalgoldys.zarzadzaniepracownikami;

public class EmploymentDetalis {

		private int employementDetalisId;
		private float emploeeSalary;
		private String emploeeEpmloyment;
		private String emploeeWorkplace;
		
		public EmploymentDetalis(int employementDetalisId, float emploeeSalary, String emploeeEpmloyment,
				String emploeeWorkplace) {
			super();
			this.employementDetalisId = employementDetalisId;
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
