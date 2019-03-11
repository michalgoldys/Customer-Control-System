package pl.michalgoldys.zarzadzaniepracownikami;

public class CustomerAdress {

	private Integer customerAdressid;
	private String customerStreet;
	private String customerCity;
	private String customerZipCode;
	
	public CustomerAdress(Integer customerAdressid, String customerStreet, String customerCity,
			String customerZipCode) {
		super();
		this.customerAdressid = customerAdressid;
		this.customerStreet = customerStreet;
		this.customerCity = customerCity;
		this.customerZipCode = customerZipCode;
	}
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
