package pl.michalgoldys.customercontrolsystem;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@ToString
@Entity(name="CUSTOMER_TECHNICAL_PANEL")
public class CustomerTechnicalPanel {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long customerTechnicalPanelId;
		
		@Column(name="customer_technical_issue_occur_date")
		private String customerTechnicalIssueOccurDate;
		
		@Column(name="customer_technical_issue_description")
		private String customerTechnicalIssueDescription;
		
		@Autowired
		@ManyToOne
		@JoinColumn(name = "customerId")
		private Customer customer;
		
		protected CustomerTechnicalPanel() {
			
		}

		public Long getCustomerTechnicalPanelId() {
			return customerTechnicalPanelId;
		}

		public void setCustomerTechnicalPanelId(Long customerTechnicalPanelId) {
			this.customerTechnicalPanelId = customerTechnicalPanelId;
		}

		public String getCustomerTechnicalIssueOccurDate() {
			return customerTechnicalIssueOccurDate;
		}

		public void setCustomerTechnicalIssueOccurDate(String customerTechnicalIssueOccurDate) {
			this.customerTechnicalIssueOccurDate = customerTechnicalIssueOccurDate;
		}

		public String getCustomerTechnicalIssueDescription() {
			return customerTechnicalIssueDescription;
		}

		public void setCustomerTechnicalIssueDescription(String customerTechnicalIssueDescription) {
			this.customerTechnicalIssueDescription = customerTechnicalIssueDescription;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
}