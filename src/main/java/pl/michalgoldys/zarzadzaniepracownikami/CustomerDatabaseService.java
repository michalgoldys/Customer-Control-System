package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDatabaseService implements CustomerDatabaseServiceInterface, DatabaseOperationInterface{

		@Autowired
		DateServiceImpl dateService;

		@Autowired
		CustomerRepository customerRepository;

		@Autowired
		CustomerRepositoryImp customerRepositoryImp;

		@Autowired
		CustomerContractDetailsRepository customerContractDetailsRepository;
		
		@Override
		public void updatingCustomer(Customer customer, CustomerAddress customerAddress, CustomerContact customerContact, String customerSelectionId)
		{
			Customer updatingCustomer = new Customer();
			
			updatingCustomer = customerFindByCustomerContractPdfId(customerSelectionId);

			Boolean isActive = customer.getCustomerIsActive();
			String activationDate = customer.getCustomerActivationDate();
			String deactivationDate = customer.getCustomerDeactivationDate();
			
			if (isActive && activationDate.length() == 0)
			{
				customer.setCustomerActivationDate(dateService.getCurrentDate());
			}
			
			if (!isActive && activationDate != null && activationDate.length() > 0 && deactivationDate.length() == 0)
			{
				customer.setCustomerDeactivationDate(dateService.getCurrentDate());
			}
			
			updatingCustomer.setCustomerName(customer.getCustomerName());
			updatingCustomer.setCustomerNip(customer.getCustomerNip());
			updatingCustomer.setCustomerIsActive(customer.getCustomerIsActive());
			updatingCustomer.setCustomerActivationDate(customer.getCustomerActivationDate());
			updatingCustomer.setCustomerDeactivationDate(customer.getCustomerDeactivationDate());

			updatingCustomer.setCustomerAddress(customerAddress);
			customerAddress.setCustomer(updatingCustomer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			updatingCustomer.setCustomerContact(customerContactList);
			customerContact.setCustomer(updatingCustomer);
			
			customerRepository.save(updatingCustomer);
		}
		
		@Override
		public void creatingCustomer(Customer customer, CustomerAddress customerAddress, CustomerContact customerContact,
									 CustomerContractDetails customerContractDetails)
		{
			customerAddress.setCustomer(customer);
			customer.setCustomerAddress(customerAddress);
			customerContact.setCustomer(customer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customer.setCustomerContact(customerContactList);		
			
			customerContractDetails.setCustomer(customer);
			customer.setCustomerContractDetails(customerContractDetails);
			
			customerRepository.save(customer);
		}
		
		@Override
		public void updatingCustomerBilling(CustomerContractDetails customerContractDetails)
		{
			Long selection = customerContractDetails.getCustomerContractDetailsId();
				
			CustomerContractDetails customerBillingDetails = customerContractDetailsRepository.findBycustomerContractDetailsId(selection);
			
			customerBillingDetails.setCustomerPlFee(customerContractDetails.getCustomerPlFee());
			customerBillingDetails.setCustomerPlSubscriptions(customerContractDetails.getCustomerPlSubscriptions());
			
			customerBillingDetails.setCustomerPlUeFee(customerContractDetails.getCustomerPlUeFee());
			customerBillingDetails.setCustomerPlUeSubscriptions(customerContractDetails.getCustomerPlUeSubscriptions());
			
			customerBillingDetails.setCustomerRuFee(customerContractDetails.getCustomerRuFee());
			customerBillingDetails.setCustomerRuSubscriptions(customerContractDetails.getCustomerRuSubscriptions());
			
			customerBillingDetails.setCustomerEinvoiceAgreement(customerContractDetails.getCustomerEinvoiceAgreement());
			
			customerContractDetailsRepository.save(customerBillingDetails);
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
			
			
			customerRepository.save(selectedCustomer);
		}
		
		@Override
		public List<Customer> findAllCustomers()
		{
			return(customerRepository.findAll());
		}
		
		@Override
		public Page<Customer> findAllCustomers(PageRequest pageRequest)
		{
			return(customerRepository.findAll(pageRequest));
		}
		
		@Override
		public List<Customer> listFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepository.findBycustomerContractPdfId(customerSelectionId));
		}
		
		@Override
		public Customer customerFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId));
		}
}