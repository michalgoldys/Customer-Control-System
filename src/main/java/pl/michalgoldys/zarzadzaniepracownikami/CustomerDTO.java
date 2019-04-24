package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Size(max=32, message="")
	private String customerName;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([0-9]){1,10}", message="Wprowadz poprawny numer NIP")
	private String customerNip;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){1,32}", message="Wprowadz poprawny format numeru umowy")
	private String customerContractId;
	
	@NotEmpty(message="Pole nie moze byc puste")
	@Pattern(regexp="([a-zA-Z0-9\\/]){1,32}", message="Wprowadz poprawny format numeru PDF")
	private String customerContractPdfId;
	
	public String getCustomerContractPdfId() {
		return customerContractPdfId;
	}

	public void setCustomerContractPdfId(String customerContractPdfId) {
		this.customerContractPdfId = customerContractPdfId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNip() {
		return customerNip;
	}

	public void setCustomerNip(String customerNip) {
		this.customerNip = customerNip;
	}

	public String getCustomerContractId() {
		return customerContractId;
	}

	public void setCustomerContractId(String customerContractId) {
		this.customerContractId = customerContractId;
	}
	 
}
