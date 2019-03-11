package pl.michalgoldys.zarzadzaniepracownikami;

public class CustomerContractDetalis {

	private int customerContractId;
	private int customerSubscriptions;
	private int customerPlSubstripctions;
	private int customerPlUeSubstripctions;
	private int customerRuSubscriptions;
	private int customerPlFee;
	private int customerPlUeFee;
	private int customerRuFee;
	
	public CustomerContractDetalis(int customerContractId, int customerSubscriptions, int customerPlSubstripctions,
			int customerPlUeSubstripctions, int customerRuSubscriptions, int customerPlFee, int customerPlUeFee,
			int customerRuFee) {
		super();
		this.customerContractId = customerContractId;
		this.customerSubscriptions = customerSubscriptions;
		this.customerPlSubstripctions = customerPlSubstripctions;
		this.customerPlUeSubstripctions = customerPlUeSubstripctions;
		this.customerRuSubscriptions = customerRuSubscriptions;
		this.customerPlFee = customerPlFee;
		this.customerPlUeFee = customerPlUeFee;
		this.customerRuFee = customerRuFee;
	}
	public int getCustomerSubscriptions() {
		return customerSubscriptions;
	}
	public void setCustomerSubscriptions(int customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}
	public int getCustomerPlSubstripctions() {
		return customerPlSubstripctions;
	}
	public void setCustomerPlSubstripctions(int customerPlSubstripctions) {
		this.customerPlSubstripctions = customerPlSubstripctions;
	}
	public int getCustomerPlUeSubstripctions() {
		return customerPlUeSubstripctions;
	}
	public void setCustomerPlUeSubstripctions(int customerPlUeSubstripctions) {
		this.customerPlUeSubstripctions = customerPlUeSubstripctions;
	}
	public int getCustomerRuSubscriptions() {
		return customerRuSubscriptions;
	}
	public void setCustomerRuSubscriptions(int customerRuSubscriptions) {
		this.customerRuSubscriptions = customerRuSubscriptions;
	}
	public int getCustomerPlFee() {
		return customerPlFee;
	}
	public void setCustomerPlFee(int customerPlFee) {
		this.customerPlFee = customerPlFee;
	}
	public int getCustomerPlUeFee() {
		return customerPlUeFee;
	}
	public void setCustomerPlUeFee(int customerPlUeFee) {
		this.customerPlUeFee = customerPlUeFee;
	}
	public int getCustomerRuFee() {
		return customerRuFee;
	}
	public void setCustomerRuFee(int customerRuFee) {
		this.customerRuFee = customerRuFee;
	}
	
	
}
