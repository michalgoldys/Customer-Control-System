package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;

public interface CustomerDatabaseServiceInterface {

	@Transactional
	void updatingCustomer(Customer customer, CustomerAddress customerAddress, CustomerContact customerContact, String customerSelectionId);
	
	@Transactional
	void creatingCustomer(Customer customer, CustomerAddress customerAddress, CustomerContact customerContact,
						  CustomerContractDetails customerContractDetails);
	
	@Transactional
	void updatingCustomerBilling(CustomerContractDetails customerContractDetails);
	
	@Transactional
	void creatingCustomerTechnicalPanelEntity(Customer selectedCustomer, CustomerTechnicalPanel customerTechnicalPanel);
	
}
