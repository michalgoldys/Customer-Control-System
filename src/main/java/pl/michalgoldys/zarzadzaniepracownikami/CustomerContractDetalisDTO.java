package pl.michalgoldys.zarzadzaniepracownikami;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CustomerContractDetalisDTO {
	
	@Max(1000)
	@Min(0)
	private Integer customerPlSubstripctions;
	
	@Max(1000)
	@Min(0)
	private Integer customerPlUeSubstripctions;
	
	@Max(1000)
	@Min(0)
	private Integer customerRuSubscriptions;

	@Max(1000)
	@Min(0)
	private Integer customerPlFee;
	
	@Max(1000)
	@Min(0)
	private Integer customerPlUeFee;
	
	@Max(1000)
	@Min(0)
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