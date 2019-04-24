package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerContactDTO {
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}", message="")
	private String customerContactName;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}", message="")
	private String customerContactSurname;
	
	@Pattern(regexp="([\\w\\.\\-_]+)?\\w+@[\\w-_]+(\\.\\w+){1,}", message="Pole nie moze byc puste")
	private String customerContactMailAdress;
	
	
	private String customerContactPhoneNumber;

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

	public String getCustomerContactMailAdress() {
		return customerContactMailAdress;
	}

	public void setCustomerContactMailAdress(String customerContactMailAdress) {
		this.customerContactMailAdress = customerContactMailAdress;
	}

	public String getCustomerContactPhoneNumber() {
		return customerContactPhoneNumber;
	}

	public void setCustomerContactPhoneNumber(String customerContactPhoneNumber) {
		this.customerContactPhoneNumber = customerContactPhoneNumber;
	}
}
