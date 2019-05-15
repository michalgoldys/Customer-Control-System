package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDatabaseService {

		@Autowired
		CustomerRepositoryImp customerRepositoryImp;
		
		@Autowired
		CustomerRepository customerRepository;
		
		@Autowired
		CustomerAdressRepository customerAdressRepository;
		
		@Autowired
		CustomerContactRepository customerContactRepository;
		
		@Autowired
		CustomerContractDetalisRepository customerContractDetalisRepository;
		
		@Transactional
		public void updateCostumer(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, 
				CustomerContractDetalis customerContractDetalis, String customerSelectionId)
		{
			
			Customer updatingCustomer = new Customer();
			//CustomerAdress customerAdressToUpdate = new CustomerAdress();
			
			//CustomerContact customerContactToUpdate = new CustomerContact();
			//CustomerContractDetalis customerContractDetalisToUpdate = new CustomerContractDetalis();
			
			updatingCustomer = customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId);
			
			//Long customerId = updatingCustomer.getCustomerId();
			
			//CustomerAdress customerAdressToUpdate = customerAdressRepository.findBycustomerId(customerId);
			
			//CustomerContact customerContactToUpdate = customerContactRepository.findBycustomerId(customerId);
			
			//CustomerContractDetalis customerContractDetalisToUpdate = customerContractDetalisRepository.findBycustomerId(customerId);
			
			updatingCustomer.setCustomerName(customer.getCustomerName());
			updatingCustomer.setCustomerNip(customer.getCustomerNip());
			
			updatingCustomer.setCustomerAdress(customerAdress);
			customerAdress.setCustomer(updatingCustomer);
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			updatingCustomer.setCustomerContact(customerContactList);
			customerContact.setCustomer(updatingCustomer);
			
			updatingCustomer.setCustomerContractDetalis(customerContractDetalis);
			customerContractDetalis.setCustomer(updatingCustomer);
			
			/*
			customerAdress.setCustomer(customer);
			customer.setCustomerAdress(customerAdress);
			customerContact.setCustomer(customer);
			
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customer.setCustomerContact(customerContactList);
			
			
			customerContractDetalis.setCustomer(customer);
			customer.setCustomerContractDetalis(customerContractDetalis);
			
			/*
			customerToUpdate.setCustomerName(customer.getCustomerName());
			customerToUpdate.setCustomerNip(customer.getCustomerNip());
			customerToUpdate.setCustomerAdress(customerAdress);
			customerToUpdate.setCustomerContractDetalis(customerContractDetalis);
			
			
			customerAdressToUpdate.setCustomerCity(customerAdress.getCustomerCity());
			customerAdressToUpdate.setCustomerStreet(customerAdress.getCustomerStreet());
			customerAdressToUpdate.setCustomerZipCode(customerAdress.getCustomerZipCode());
		
			customerContactToUpdate.setCustomerContactName(customerContact.getCustomerContactName());
			customerContactToUpdate.setCustomerContactSurname(customerContact.getCustomerContactSurname());
			customerContactToUpdate.setCustomerContactPhoneNumber(customerContact.getCustomerContactPhoneNumber());
			customerContactToUpdate.setCustomerContactMailAdress(customerContact.getCustomerContactMailAdress());
			
			customerContractDetalisToUpdate.setCustomerPlSubstripctions(customerContractDetalis.getCustomerPlSubstripctions());
			customerContractDetalisToUpdate.setCustomerPlUeSubstripctions(customerContractDetalis.getCustomerPlUeSubstripctions());
			customerContractDetalisToUpdate.setCustomerRuSubscriptions(customerContractDetalis.getCustomerRuSubscriptions());
			*/
			
			customerRepository.save(updatingCustomer);
			
			//customerAdressRepository.save(customerAdressToUpdate);
			//customerContactRepository.save(customerContactToUpdate);
			//customerContractDetalisRepository.save(customerContractDetalisToUpdate);
			
		}
}
