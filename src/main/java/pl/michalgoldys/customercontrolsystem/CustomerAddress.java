package pl.michalgoldys.customercontrolsystem;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@ToString
@Entity(name="CUSTOMER_ADRESS")
public class CustomerAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerAddressId;
	
	@Column(name="customer_street")
	private String customerStreet;
	
	@Column(name="customer_city")
	private String customerCity;
	
	@Column(name="customer_zip_code")
	private String customerZipCode;
	
	@Autowired
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	protected CustomerAddress() {
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Long getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(Long customerAddressId) {
		this.customerAddressId = customerAddressId;
	}
	
}
