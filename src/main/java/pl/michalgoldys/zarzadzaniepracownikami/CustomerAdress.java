package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="CUSTOMER_ADRESS")
public class CustomerAdress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerAdressId;
	
	@Column(name="customer_street", nullable=true)
	private String customerStreet;
	
	@Column(name="customer_city", nullable=false)
	private String customerCity;
	
	@Column(name="customer_zip_code", nullable=false)
	private String customerZipCode;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name ="customerId")
	Customer customer;
	
	protected CustomerAdress() {
		
	}
	
	public CustomerAdress(String customerStreet, String customerCity,
			String customerZipCode) {
		super();
		this.customerStreet = customerStreet;
		this.customerCity = customerCity;
		this.customerZipCode = customerZipCode;
	}
	public String getCustomerStreet() {
		return customerStreet;
	}
	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerZipCode() {
		return customerZipCode;
	}
	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}
	
}
