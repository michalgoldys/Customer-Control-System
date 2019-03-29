package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CompanyAdressDTO {
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=0, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){0,32}")
	private String companyStreet;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=1, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}")
	private String companyCity;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(min=1, max=32, message="Maksymalna dlugosc 32 znaki!")
	@Pattern(regexp="([a-zA-Z0-9]){1,32}")
	private String companyCountry;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="[0-9]{2}-[0-9]{3}")
	private String companyZipCode;

	public String getCompanyStreet() {
		return companyStreet;
	}

	public void setCompanyStreet(String companyStreet) {
		this.companyStreet = companyStreet;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getCompanyZipCode() {
		return companyZipCode;
	}

	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}
	
	
}
