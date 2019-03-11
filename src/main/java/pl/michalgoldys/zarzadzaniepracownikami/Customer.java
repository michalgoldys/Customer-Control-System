package pl.michalgoldys.zarzadzaniepracownikami;

public class Customer {
	
	private int customerId;
	private String customerName;
	private int customerNip;
	
	public String getCustomerName() {
		return customerName;
	}
	public Customer(int customerId, String customerName, int customerNip) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNip = customerNip;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerNip() {
		return customerNip;
	}
	public void setCustomerNip(int customerNip) {
		this.customerNip = customerNip;
	}
		
}
