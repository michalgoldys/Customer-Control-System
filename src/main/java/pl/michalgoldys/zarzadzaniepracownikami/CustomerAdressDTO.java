package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerAdressDTO {
	
	@Size(min=0, max=32)
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){0,32}")
	private String customerStreet;
	
	@NotEmpty
	@Size(min=1, max=32)
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){0,32}")
	private String customerCity;
	
	@NotEmpty
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