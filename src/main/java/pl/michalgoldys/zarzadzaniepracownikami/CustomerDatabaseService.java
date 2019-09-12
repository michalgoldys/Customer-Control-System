package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerDatabaseService implements CustomerDatabaseServiceImplementation, DatabaseOperationInterface{
		
		@Autowired
		CustomerJpaRepository customerJpaRepository;
		
		@Autowired
		CustomerRepositoryImp customerRepositoryImp;
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		CustomerContractDetalisRepository customerContractDetalisRepository;
		
		@Override
		public void updatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, String customerSelectionId)
		{
			Customer updatingCustomer = new Customer();
			
			updatingCustomer = customerFindByCustomerContractPdfId(customerSelectionId);

			Boolean isActive = customer.getCustomerIsActive();
			String activationDate = customer.getCustomerActivationDate();
			String deactivationDate = customer.getCustomerDeactivationDate();
			
			if (isActive && activationDate.length() == 0)
			{
				customer.setCustomerActivationDate(customerService.getCurrentDateAsString());
			}
			
			if (!isActive && activationDate != null && activationDate.length() > 0 && deactivationDate.length() == 0)
			{
				customer.setCustomerDeactivationDate(customerService.getCurrentDateAsString());
			}
			
			updatingCustomer.setCustomerName(customer.getCustomerName());
			updatingCustomer.setCustomerNip(customer.getCustomerNip());
			updatingCustomer.setCustomerIsActive(customer.getCustomerIsActive());
			updatingCustomer.setCustomerActivationDate(customer.getCustomerActivationDate());
			updatingCustomer.setCustomerDeactivationDate(customer.getCustomerDeactivationDate());

			updatingCustomer.setCustomerAdress(customerAdress);
			customerAdress.setCustomer(updatingCustomer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			updatingCustomer.setCustomerContact(customerContactList);
			customerContact.setCustomer(updatingCustomer);
			
			customerJpaRepository.save(updatingCustomer);
		}
		
		@Override
		public void creatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, 
				CustomerContractDetalis customerContractDetalis)
		{
			customerAdress.setCustomer(customer);
			customer.setCustomerAdress(customerAdress);
			customerContact.setCustomer(customer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customer.setCustomerContact(customerContactList);		
			
			customerContractDetalis.setCustomer(customer);
			customer.setCustomerContractDetalis(customerContractDetalis);
			
			customerJpaRepository.save(customer);
		}
		
		@Override
		public void updatingCustomerBilling(CustomerContractDetalis customerContractDetalis)
		{
			Long selection = customerContractDetalis.getCustomerContractDetalisId();
				
			CustomerContractDetalis customerBillingDetalis = customerContractDetalisRepository.findBycustomerContractDetalisId(selection);
			
			customerBillingDetalis.setCustomerPlFee(customerContractDetalis.getCustomerPlFee());
			customerBillingDetalis.setCustomerPlSubstripctions(customerContractDetalis.getCustomerPlSubstripctions());
			
			customerBillingDetalis.setCustomerPlUeFee(customerContractDetalis.getCustomerPlUeFee());
			customerBillingDetalis.setCustomerPlUeSubstripctions(customerContractDetalis.getCustomerPlUeSubstripctions());
			
			customerBillingDetalis.setCustomerRuFee(customerContractDetalis.getCustomerRuFee());
			customerBillingDetalis.setCustomerRuSubscriptions(customerContractDetalis.getCustomerRuSubscriptions());
			
			customerBillingDetalis.setCustomerEinvoiceAgreement(customerContractDetalis.getCustomerEinvoiceAgreement());
			
			customerContractDetalisRepository.save(customerBillingDetalis);
		}
		
		@Override
		public void creatingCustomerTechnicalPanelEntity(Customer selectedCustomer, CustomerTechnicalPanel customerTechnicalPanel)
		{
			
			CustomerTechnicalPanel newCustomerTechnicalPanel = new CustomerTechnicalPanel();
			
			newCustomerTechnicalPanel.setCustomerTechnicalIssueDescribtion(customerTechnicalPanel.getCustomerTechnicalIssueDescribtion());
			newCustomerTechnicalPanel.setCustomerTechnicalIssueOccourDate(customerTechnicalPanel.getCustomerTechnicalIssueOccourDate());
			
			newCustomerTechnicalPanel.setCustomer(selectedCustomer);
			
			List<CustomerTechnicalPanel> customerTechnicalPanelList = new ArrayList<CustomerTechnicalPanel>();
			customerTechnicalPanelList.add(newCustomerTechnicalPanel);
			
			selectedCustomer.setCustomerTechnicalPanel(customerTechnicalPanelList);
			
			
			customerJpaRepository.save(selectedCustomer);
		}
		
		@Override
		public List<Customer> findAllCustomers()
		{
			return(customerJpaRepository.findAll());
		}
		
		@Override
		public Page<Customer> findAllCustomers(PageRequest pageRequest)
		{
			return(customerJpaRepository.findAll(pageRequest));
		}
		
		@Override
		public List<Customer> listFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerJpaRepository.findBycustomerContractPdfId(customerSelectionId));
		}
		
		@Override
		public Customer customerFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId));
		}
}