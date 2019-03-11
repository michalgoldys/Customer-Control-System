package pl.michalgoldys.zarzadzaniepracownikami;

public class CustomerContact {

	private Integer customerContactId;
	
	private String contactName;
	private String contactSurname;
	private int customerPhoneNumber;
	private String customerMailAdress;
	
	public CustomerContact(Integer customerContactId, String contactName, String contactSurname,
			int customerPhoneNumber, String customerMailAdress) {
		super();
		this.customerContactId = customerContactId;
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
