package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.Pattern;

public class CustomerContractDetalisDTO {
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerPlSubstripctions;
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerPlUeSubstripctions;
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerRuSubscriptions;
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerPlFee;
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerPlUeFee;
	
	@Pattern(regexp="([0-9]){0,16}")
	private Integer customerRuFee;

	public Integer getCustomerPlSubstripctions() {
		return customerPlSubstripctions;
	}

	public void setCustomerPlSubstripctions(Integer customerPlSubstripctions) {
		this.customerPlSubstripctions = customerPlSubstripctions;
	}

	public Integer getCustomerPlUeSubstripctions() {
		return customerPlUeSubstripctions;
	}

	public void setCustomerPlUeSubstripctions(Integer customerPlUeSubstripctions) {
		this.customerPlUeSubstripctions = customerPlUeSubstripctions;
	}

	public Integer getCustomerRuSubscriptions() {
		return customerRuSubscriptions;
	}

	public void setCustomerRuSubscriptions(Integer customerRuSubscriptions) {
		this.customerRuSubscriptions = customerRuSubscriptions;
	}

	public Integer getCustomerPlFee() {
		return customerPlFee;
	}

	public void setCustomerPlFee(Integer customerPlFee) {
		this.customerPlFee = customerPlFee;
	}

	public Integer getCustomerPlUeFee() {
		return customerPlUeFee;
	}

	public void setCustomerPlUeFee(Integer customerPlUeFee) {
		this.customerPlUeFee = customerPlUeFee;
	}

	public Integer getCustomerRuFee() {
		return customerRuFee;
	}

	public void setCustomerRuFee(Integer customerRuFee) {
		this.customerRuFee = customerRuFee;
	}
	
	
}