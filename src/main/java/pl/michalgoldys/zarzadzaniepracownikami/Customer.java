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
	private int customerNip;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="CUSTOMER")
	private List<CustomerAdress> customerAdress;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="CUSTOMER")
	private List<CustomerContact> customerContact;
	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy="CUSTOMER")
	private List<CustomerContractDetalis> customerContractDetalis;
	
	protected Customer () {
		
	}
	public Customer(String customerName, int customerNip) {
		super();
		this.customerName = customerName;
		this.customerNip = customerNip;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerNip() {
		return customerNip;
	}
	public void setCustomerNip(int customerNip) {
		this.customerNip = customerNip;
	}
		
}
