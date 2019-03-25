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

@Entity(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="customer_nip", nullable=false)
	private Integer customerNip;
	
	@Column(name="customer_is_active")
	private Boolean customerIsActive;
	
	@Column(name="customer_contract_id")
	private String customerContractId;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer")
	private List<CustomerAdress> customerAdress;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer")
	private List<CustomerContact> customerContact;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer")
	private List<CustomerContractDetalis> customerContractDetalis;
	
	protected Customer () {
		
	}
	public Customer(String customerName, Integer customerNip, Boolean customerIsActive, String customerContractId) {
		super();
		this.customerName = customerName;
		this.customerNip = customerNip;
		this.customerIsActive = customerIsActive;
		this.customerContractId = customerContractId;
	}
	
	public String getCustomerContractId() {
		return customerContractId;
	}
	public void setCustomerContractId(String customerContractId) {
		this.customerContractId = customerContractId;
	}
	public Boolean isCustomerIsActive() {
		return customerIsActive;
	}
	public void setCustomerIsActive(Boolean customerIsActive) {
		this.customerIsActive = customerIsActive;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerNip() {
		return customerNip;
	}
	public void setCustomerNip(Integer customerNip) {
		this.customerNip = customerNip;
	}
		
}
