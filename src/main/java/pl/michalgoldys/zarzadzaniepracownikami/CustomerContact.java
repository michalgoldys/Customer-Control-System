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
	private int customerContactPhoneNumber;
	
	@Column(name="customer_contact_mail_adress", nullable=true)
	private String customerContactMailAdress;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name ="customerId")
	Customer customer;
	
	protected CustomerContact() {
		
	}
	
	public CustomerContact(String contactName, String contactSurname,
			int customerPhoneNumber, String customerMailAdress) {
		super();
		this.customerContactName = contactName;
		this.customerContactSurname = contactSurname;
		this.customerContactPhoneNumber = customerPhoneNumber;
		this.customerContactMailAdress = customerMailAdress;
	}
	public String getContactName() {
		return customerContactName;
	}
	public void setContactName(String contactName) {
		this.customerContactName = contactName;
	}
	public String getContactSurname() {
		return customerContactSurname;
	}
	public void setContactSurname(String contactSurname) {
		this.customerContactSurname = contactSurname;
	}
	public int getCustomerPhoneNumber() {
		return customerContactPhoneNumber;
	}
	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerContactPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerMailAdress() {
		return customerContactMailAdress;
	}
	public void setCustomerMailAdress(String customerMailAdress) {
		this.customerContactMailAdress = customerMailAdress;
	}
		
}
