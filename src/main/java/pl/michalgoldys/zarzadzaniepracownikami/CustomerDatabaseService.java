package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDatabaseService {
		
		@Autowired
		CustomerRepository customerRepository;
		
		@Autowired
		CustomerRepositoryImp customerRepositoryImp;
		
		@Autowired
		CustomerService customerService;
		
		@Transactional
		public void updatingCustomer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, 
				CustomerContractDetalis customerContractDetalis, String customerSelectionId)
		{
			Customer updatingCustomer = new Customer();
			
			updatingCustomer = customerFindByCustomerContractPdfId(customerSelectionId);
			
			if (customer.getCustomerActivationDate() != null && !customer.getCustomerActivationDate().isEmpty())
			{
				customer.setCustomerIsActive(true);
			}
			else if (customer.getCustomerIsActive() == true && customer.getCustomerActivationDate() == null)
			{
				customer.setCustomerActivationDate(customerService.getCurrentDate());
			}
			
			
			updatingCustomer.setCustomerName(customer.getCustomerName());
			updatingCustomer.setCustomerNip(customer.getCustomerNip());
			updatingCustomer.setCustomerIsActive(customer.getCustomerIsActive());
			updatingCustomer.setCustomerActivationDate(customer.getCustomerActivationDate());
			
			updatingCustomer.setCustomerAdress(customerAdress);
			customerAdress.setCustomer(updatingCustomer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			updatingCustomer.setCustomerContact(customerContactList);
			customerContact.setCustomer(updatingCustomer);
			
			updatingCustomer.setCustomerContractDetalis(customerContractDetalis);
			customerContractDetalis.setCustomer(updatingCustomer);
			
			customerRepository.save(updatingCustomer);
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
			
			customerRepository.save(customer);
		}
		
		@Transactional
		public List<Customer> findAllCustomers()
		{
			return(customerRepository.findAll());
		}
		
		@Transactional
		public List<Customer> listFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepository.findBycustomerContractPdfId(customerSelectionId));
		}
		
		@Transactional
		public Customer customerFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId));
		}
}