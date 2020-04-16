package pl.michalgoldys.customercontrolsystem;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@ToString
@Entity(name="CUSTOMER_CONTRACT_DETALIS")
public class CustomerContractDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerContractDetailsId;
	
	@Column(name="customer_subscriptions")
	private Integer customerSubscriptions;
	
	@Column(name="customer_pl_substripctions")
	private Integer customerPlSubscriptions;
	
	@Column(name="customer_pl_ue_substripctions")
	private Integer customerPlUeSubscriptions;
	
	@Column(name="customer_ru_subscriptions")
	private Integer customerRuSubscriptions;
	
	@Column(name="customer_pl_fee")
	private Integer customerPlFee;
	
	@Column(name="customer_pl_ue_fee")
	private Integer customerPlUeFee;
	
	@Column(name="customer_ru_fee")
	private Integer customerRuFee;
	
	@Column(name="customer_einvoice_agreement")
	private Boolean customerEinvoiceAgreement;
	
	@Autowired
	@OneToOne
	@JoinColumn(name ="customerId")
	Customer customer;
	
	protected CustomerContractDetails() {
		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCustomerSubscriptions() {
		return customerSubscriptions;
	}

	public void setCustomerSubscriptions(Integer customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}

	public Integer getCustomerPlSubscriptions() {
		return customerPlSubscriptions;
	}

	public void setCustomerPlSubscriptions(Integer customerPlSubstripctions) {
		this.customerPlSubscriptions = customerPlSubstripctions;
	}

	public Integer getCustomerPlUeSubscriptions() {
		return customerPlUeSubscriptions;
	}

	public void setCustomerPlUeSubscriptions(Integer customerPlUeSubscriptions) {
		this.customerPlUeSubscriptions = customerPlUeSubscriptions;
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

	public Boolean getCustomerEinvoiceAgreement() {
		return customerEinvoiceAgreement;
	}

	public void setCustomerEinvoiceAgreement(Boolean customerEinvoiceAgreement) {
		this.customerEinvoiceAgreement = customerEinvoiceAgreement;
	}

	public Long getCustomerContractDetailsId() {
		return customerContractDetailsId;
	}

	public void setCustomerContractDetailsId(Long customerContractDetailsId) {
		this.customerContractDetailsId = customerContractDetailsId;
	}
}