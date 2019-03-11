package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAdress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerAdressid;
	
	private String customerStreet;
	private String customerCity;
	private String customerZipCode;
	
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
