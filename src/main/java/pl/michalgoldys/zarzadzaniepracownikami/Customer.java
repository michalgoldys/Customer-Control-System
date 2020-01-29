package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_nip")
	private String customerNip;
	
	@Column(name="customer_is_active")
	private Boolean customerIsActive;
	
	@Column(name="customer_contract_id")
	private String customerContractId;
	
	@Column(name="customer_contract_pdf_id")
	private String customerContractPdfId;
	
	@Column(name="customer_activation_date")
	private String customerActivationDate;
	
	@Column(name="customer_deactivation_date")
	private String customerDeactivationDate;

	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private List<CustomerContact> customerContact;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private CustomerContractDetails customerContractDetails;

	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private List<CustomerTechnicalPanel> customerTechnicalPanel;
	
	protected Customer () {
		
	}
	
	public Customer(String customerName, String customerNip, Boolean customerIsActive, String customerContractId) {
		super();
		this.customerName = customerName;
		this.customerNip = customerNip;
		this.customerIsActive = customerIsActive;
		this.customerContractId = customerContractId;
	}
	
	public CustomerContractDetails getCustomerContractDetails() {
		return customerContractDetails;
	}

	public void setCustomerContractDetails(CustomerContractDetails customerContractDetails) {
		this.customerContractDetails = customerContractDetails;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<CustomerContact> getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(List<CustomerContact> customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerContractId() {
		return customerContractId;
	}
	public void setCustomerContractId(String customerContractId) {
		this.customerContractId = customerContractId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNip() {
		return customerNip;
	}
	public void setCustomerNip(String customerNip) {
		this.customerNip = customerNip;
	}

	public String getCustomerContractPdfId() {
		return customerContractPdfId;
	}

	public void setCustomerContractPdfId(String customerContractPdfId) {
		this.customerContractPdfId = customerContractPdfId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerActivationDate() {
		return customerActivationDate;
	}

	public void setCustomerActivationDate(String customerActivationDate) {
		this.customerActivationDate = customerActivationDate;
	}

	public String getCustomerDeactivationDate() {
		return customerDeactivationDate;
	}

	public void setCustomerDeactivationDate(String customerDeactivationDate) {
		this.customerDeactivationDate = customerDeactivationDate;
	}

	public Boolean getCustomerIsActive() {
		return customerIsActive;
	}

	public void setCustomerIsActive(Boolean customerIsActive) {
		this.customerIsActive = customerIsActive;
	}

	public List<CustomerTechnicalPanel> getCustomerTechnicalPanel() {
		return customerTechnicalPanel;
	}

	public void setCustomerTechnicalPanel(List<CustomerTechnicalPanel> customerTechnicalPanel) {
		this.customerTechnicalPanel = customerTechnicalPanel;
	}
}