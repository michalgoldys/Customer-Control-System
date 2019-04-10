package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {
	
	@Size(max=32)
	private String customerName;
	
	@Pattern(regexp="([0-9]){1,10}")
	private String customerNip;
	
	@NotEmpty
	@Pattern(regexp="([a-zA-Z0-9\\/\\s]){0,32}")
	private String customerContractId;
	
	@NotEmpty
	@Pattern(regexp="([a-zA-Z0-9\\/]){0,32}")
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
