package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="customer_nip", nullable=false)
	private int customerNip;
	
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
