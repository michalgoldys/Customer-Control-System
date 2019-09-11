package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;

public interface CustomerDatabaseServiceImplementation {

	@Transactional
	void updatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, String customerSelectionId);
	
	@Transactional
	void creatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, 
			CustomerContractDetalis customerContractDetalis);
	
	@Transactional
	void updatingCustomerBilling(CustomerContractDetalis customerContractDetalis);
	
	@Transactional
	void creatingCustomerTechnicalPanelEntity(Customer selectedCustomer, CustomerTechnicalPanel customerTechnicalPanel);
	
}
