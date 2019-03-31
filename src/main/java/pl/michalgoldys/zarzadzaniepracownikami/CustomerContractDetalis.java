package pl.michalgoldys.zarzadzaniepracownikami;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="CUSTOMER_CONTRACT_DETALIS")
public class CustomerContractDetalis {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContractId;
	
	@Column(name="customer_subscriptions", nullable=true)
	private Integer customerSubscriptions;
	
	@Column(name="customer_pl_substripctions", nullable=true)
	private Integer customerPlSubstripctions;
	
	@Column(name="customer_pl_ue_substripctions", nullable=true)
	private Integer customerPlUeSubstripctions;
	
	@Column(name="customer_ru_subscriptions", nullable=true)
	private Integer customerRuSubscriptions;
	
	@Column(name="customer_pl_fee", nullable=true)
	private Integer customerPlFee;
	
	@Column(name="customer_pl_ue_fee", nullable=true)
	private Integer customerPlUeFee;
	
	@Column(name="customer_ru_fee", nullable=true)
	private Integer customerRuFee;
	
	@Column(name="customer_einvoice_agreement")
	private Boolean customerEinvoiceAgreement;
	
	@Autowired
	@OneToOne
	@JoinColumn(name ="customerId")
	Customer customer;
	
	protected CustomerContractDetalis() {
		
	}
	
	public CustomerContractDetalis(Integer customerSubscriptions, Integer customerPlSubstripctions,
			Integer customerPlUeSubstripctions, Integer customerRuSubscriptions, Integer customerPlFee, Integer customerPlUeFee,
			Integer customerRuFee, Boolean customerEinvoiceAgreement) {
		super();
		this.customerSubscriptions = customerSubscriptions;
		this.customerPlSubstripctions = customerPlSubstripctions;
		this.customerPlUeSubstripctions = customerPlUeSubstripctions;
		this.customerRuSubscriptions = customerRuSubscriptions;
		this.customerPlFee = customerPlFee;
		this.customerPlUeFee = customerPlUeFee;
		this.customerRuFee = customerRuFee;
		this.customerEinvoiceAgreement = customerEinvoiceAgreement;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isCustomerEinvoiceAgreement() {
		return customerEinvoiceAgreement;
	}

	public void setCustomerEinvoiceAgreement(Boolean customerEinvoiceAgreement) {
		this.customerEinvoiceAgreement = customerEinvoiceAgreement;
	}

	public int getCustomerSubscriptions() {
		return customerSubscriptions;
	}
	public void setCustomerSubscriptions(Integer customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}
	public int getCustomerPlSubstripctions() {
		return customerPlSubstripctions;
	}
	public void setCustomerPlSubstripctions(Integer customerPlSubstripctions) {
		this.customerPlSubstripctions = customerPlSubstripctions;
	}
	public int getCustomerPlUeSubstripctions() {
		return customerPlUeSubstripctions;
	}
	public void setCustomerPlUeSubstripctions(Integer customerPlUeSubstripctions) {
		this.customerPlUeSubstripctions = customerPlUeSubstripctions;
	}
	public int getCustomerRuSubscriptions() {
		return customerRuSubscriptions;
	}
	public void setCustomerRuSubscriptions(Integer customerRuSubscriptions) {
		this.customerRuSubscriptions = customerRuSubscriptions;
	}
	public int getCustomerPlFee() {
		return customerPlFee;
	}
	public void setCustomerPlFee(Integer customerPlFee) {
		this.customerPlFee = customerPlFee;
	}
	public int getCustomerPlUeFee() {
		return customerPlUeFee;
	}
	public void setCustomerPlUeFee(Integer customerPlUeFee) {
		this.customerPlUeFee = customerPlUeFee;
	}
	public int getCustomerRuFee() {
		return customerRuFee;
	}
	public void setCustomerRuFee(Integer customerRuFee) {
		this.customerRuFee = customerRuFee;
	}
}