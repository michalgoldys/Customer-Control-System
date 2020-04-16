package pl.michalgoldys.customercontrolsystem;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@ToString
@Entity(name="CUSTOMER_CONTACT")
public class CustomerContact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContactId;
	
	@Column(name="customer_contact_name")
	private String customerContactName;
	
	@Column(name="customer_contact_surname")
	private String customerContactSurname;
	
	@Column(name="customer_contact_phone_number")
	private String customerContactPhoneNumber;
	
	@Column(name="customer_contact_mail_adress")
	private String customerContactMailAddress;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "customerId")
	Customer customer;
	
	protected CustomerContact() {
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerContactName() {
		return customerContactName;
	}

	public void setCustomerContactName(String customerContactName) {
		this.customerContactName = customerContactName;
	}

	public String getCustomerContactSurname() {
		return customerContactSurname;
	}

	public void setCustomerContactSurname(String customerContactSurname) {
		this.customerContactSurname = customerContactSurname;
	}

	public String getCustomerContactPhoneNumber() {
		return customerContactPhoneNumber;
	}

	public void setCustomerContactPhoneNumber(String customerContactPhoneNumber) {
		this.customerContactPhoneNumber = customerContactPhoneNumber;
	}

	public String getCustomerContactMailAddress() {
		return customerContactMailAddress;
	}

	public void setCustomerContactMailAddress(String customerContactMailAdress) {
		this.customerContactMailAddress = customerContactMailAdress;
	}

	public Long getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(Long customerContactId) {
		this.customerContactId = customerContactId;
	}
	
}
