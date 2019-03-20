package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="CUSTOMER_CONTRACT_DETALIS")
public class CustomerContractDetalis {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContractId;
	
	@Column(name="customer_subscriptions", nullable=true)
	private int customerSubscriptions;
	
	@Column(name="customer_pl_substripctions", nullable=true)
	private int customerPlSubstripctions;
	
	@Column(name="customer_pl_ue_substripctions", nullable=true)
	private int customerPlUeSubstripctions;
	
	@Column(name="customer_ru_subscriptions", nullable=true)
	private int customerRuSubscriptions;
	
	@Column(name="customer_pl_fee", nullable=true)
	private int customerPlFee;
	
	@Column(name="customer_pl_ue_fee", nullable=true)
	private int customerPlUeFee;
	
	@Column(name="customer_ru_fee", nullable=true)
	private int customerRuFee;
	
	@Autowired
	@ManyToOne
	Customer customer;
	
	protected CustomerContractDetalis() {
		
	}
	
	public CustomerContractDetalis(int customerSubscriptions, int customerPlSubstripctions,
			int customerPlUeSubstripctions, int customerRuSubscriptions, int customerPlFee, int customerPlUeFee,
			int customerRuFee) {
		super();
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