package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerContact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContactId;
	
	private String contactName;
	private String contactSurname;
	private int customerPhoneNumber;
	private String customerMailAdress;
	
	protected CustomerContact() {
		
	}
	
	public CustomerContact(String contactName, String contactSurname,
			int customerPhoneNumber, String customerMailAdress) {
		super();
		this.contactName = contactName;
		this.contactSurname = contactSurname;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerMailAdress = customerMailAdress;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactSurname() {
		return contactSurname;
	}
	public void setContactSurname(String contactSurname) {
		this.contactSurname = contactSurname;
	}
	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerMailAdress() {
		return customerMailAdress;
	}
	public void setCustomerMailAdress(String customerMailAdress) {
		this.customerMailAdress = customerMailAdress;
	}
		
}
