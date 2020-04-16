package pl.michalgoldys.customercontrolsystem;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerAddressDTO {
	
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){0,32}", message="")
	private String customerStreet;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){0,32}", message="Wprowadz poprawna nazwe")
	private String customerCity;

	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="[0-9]{2}-[0-9]{3}", message="Nieprawidlowy kod pocztowy")
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