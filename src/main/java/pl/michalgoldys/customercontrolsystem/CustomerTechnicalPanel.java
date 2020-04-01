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
		
		@Column(name="customer_technical_issue_occour_date")
		private String customerTechnicalIssueOccourDate;
		
		@Column(name="customer_technical_issue_describtion")
		private String customerTechnicalIssueDescribtion;
		
		@Autowired
		@ManyToOne
		@JoinColumn(name = "customerId")
		Customer customer;
		
		protected CustomerTechnicalPanel() {
			
		}

		public Long getCustomerTechnicalPanelId() {
			return customerTechnicalPanelId;
		}

		public void setCustomerTechnicalPanelId(Long customerTechnicalPanelId) {
			this.customerTechnicalPanelId = customerTechnicalPanelId;
		}

		public String getCustomerTechnicalIssueOccourDate() {
			return customerTechnicalIssueOccourDate;
		}

		public void setCustomerTechnicalIssueOccourDate(String customerTechnicalIssueOccourDate) {
			this.customerTechnicalIssueOccourDate = customerTechnicalIssueOccourDate;
		}

		public String getCustomerTechnicalIssueDescribtion() {
			return customerTechnicalIssueDescribtion;
		}

		public void setCustomerTechnicalIssueDescribtion(String customerTechnicalIssueDescribtion) {
			this.customerTechnicalIssueDescribtion = customerTechnicalIssueDescribtion;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
}