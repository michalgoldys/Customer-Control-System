package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="customer_nip", nullable=false)
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
	private CustomerAdress customerAdress;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private List<CustomerContact> customerContact;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	private CustomerContractDetalis customerContractDetalis;

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
	
	public CustomerContractDetalis getCustomerContractDetalis() {
		return customerContractDetalis;
	}

	public void setCustomerContractDetalis(CustomerContractDetalis customerContractDetalis) {
		this.customerContractDetalis = customerContractDetalis;
	}

	public CustomerAdress getCustomerAdress() {
		return customerAdress;
	}

	public void setCustomerAdress(CustomerAdress customerAdress) {
		this.customerAdress = customerAdress;
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