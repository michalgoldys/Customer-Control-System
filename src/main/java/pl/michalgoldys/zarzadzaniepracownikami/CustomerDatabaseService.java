package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerDatabaseService {
		
		@Autowired
		CustomerJpaRepository customerJpaRepository;
		
		@Autowired
		CustomerRepositoryImp customerRepositoryImp;
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		CustomerContractDetalisRepository customerContractDetalisRepository;
		
		@Transactional
		public void updatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, String customerSelectionId)
		{
			Customer updatingCustomer = new Customer();
			
			updatingCustomer = customerFindByCustomerContractPdfId(customerSelectionId);

			Boolean isActive = customer.getCustomerIsActive();
			String activationDate = customer.getCustomerActivationDate();
			String deactivationDate = customer.getCustomerDeactivationDate();
			
			if (isActive && activationDate.length() == 0)
			{
				customer.setCustomerActivationDate(customerService.getCurrentDate());
			}
			
			if (!isActive && activationDate != null && activationDate.length() > 0 && deactivationDate.length() == 0)
			{
				customer.setCustomerDeactivationDate(customerService.getCurrentDate());
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
		
		@Transactional
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
		
		@Transactional
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
		
		@Transactional
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
		
		@Transactional
		public List<Customer> findAllCustomers()
		{
			return(customerJpaRepository.findAll());
		}
		
		@Transactional
		public Page<Customer> findAllCustomers(PageRequest pageRequest)
		{
			return(customerJpaRepository.findAll(pageRequest));
		}
		
		@Transactional
		public List<Customer> listFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerJpaRepository.findBycustomerContractPdfId(customerSelectionId));
		}
		
		@Transactional
		public Customer customerFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId));
		}
}