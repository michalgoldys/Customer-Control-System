package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.Pattern;

public class CompanyContactDetalisDTO {

	@Pattern(regexp="[0-9] {,9}", message="Bledny Numer Telefonu")
	private String companyContactNumber;
	
	@Pattern(regexp="^([\\d]{9})|([\\d]{3})((?: |-)[\\d]{3}){2}|([\\d]{2}(?: |-)(([\\d]{7})|([\\d]{3}((?: |-)[\\d]{2}){2})))$", message="Bledny Numer Telefonu")
	private String companyMainContactNumber;
	
	@Pattern(regexp="([\\w\\.\\-_]+)?\\w+@[\\w-_]+(\\.\\w+){1,}", message="Bledny Adres e-mail")
	private String companyEmailAdress;
	
	public String getCompanyContactNumber() {
		return companyContactNumber;
	}
	public void setCompanyContactNumber(String companyContactNumber) {
		this.companyContactNumber = companyContactNumber;
	}
	public String getCompanyMainContactNumber() {
		return companyMainContactNumber;
	}
	public void setCompanyMainContactNumber(String companyMainContactNumber) {
		this.companyMainContactNumber = companyMainContactNumber;
	}
	public String getCompanyEmailAdress() {
		return companyEmailAdress;
	}
	public void setCompanyEmailAdress(String companyEmailAdress) {
		this.companyEmailAdress = companyEmailAdress;
	}
	
	
}
