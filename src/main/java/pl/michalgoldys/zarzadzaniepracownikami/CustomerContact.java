package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="CUSTOMER_CONTACT")
public class CustomerContact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContactId;
	
	@Column(name="customer_contact_name", nullable=false)
	private String customerContactName;
	
	@Column(name="customer_contact_surname", nullable=false)
	private String customerContactSurname;
	
	@Column(name="customer_contact_phone_number", nullable=false)
	private Integer customerContactPhoneNumber;
	
	@Column(name="customer_contact_mail_adress", nullable=true)
	private String customerContactMailAdress;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "customerId")
	Customer customer;
	
	protected CustomerContact() {
		
	}
	
	public CustomerContact(String contactName, String contactSurname,
			Integer customerPhoneNumber, String customerMailAdress) {
		super();
		this.customerContactName = contactName;
		this.customerContactSurname = contactSurname;
		this.customerContactPhoneNumber = customerPhoneNumber;
		this.customerContactMailAdress = customerMailAdress;
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

	public Integer getCustomerContactPhoneNumber() {
		return customerContactPhoneNumber;
	}

	public void setCustomerContactPhoneNumber(Integer customerContactPhoneNumber) {
		this.customerContactPhoneNumber = customerContactPhoneNumber;
	}

	public String getCustomerContactMailAdress() {
		return customerContactMailAdress;
	}

	public void setCustomerContactMailAdress(String customerContactMailAdress) {
		this.customerContactMailAdress = customerContactMailAdress;
	}
}
