package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerAdressDTO {
	
	@Size(min=0, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){0,32}")
	private String customerStreet;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=1, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){0,32}")
	private String customerCity;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="[0-9]{2}-[0-9]{3}")
	private String customerZipCode;

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