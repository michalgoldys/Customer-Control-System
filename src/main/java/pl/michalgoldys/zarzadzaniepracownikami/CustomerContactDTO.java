package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerContactDTO {
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=0, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}")
	private String customerContactName;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=0, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}")
	private String customerContactSurname;
	
	@Pattern(regexp="([\\w\\.\\-_]+)?\\w+@[\\w-_]+(\\.\\w+){1,}")
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
