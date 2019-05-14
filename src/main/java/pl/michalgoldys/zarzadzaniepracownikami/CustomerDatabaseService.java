package pl.michalgoldys.zarzadzaniepracownikami;

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
			
			
			Customer customerToUpdate = customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId);
			
			Long customerId = customerToUpdate.getCustomerId();
			
			CustomerAdress customerAdressToUpdate = customerAdressRepository.findBycustomerId(customerId);
			
			CustomerContact customerContactToUpdate = customerContactRepository.findBycustomerId(customerId);
			
			CustomerContractDetalis customerContractDetalisToUpdate = customerContractDetalisRepository.findBycustomerId(customerId);
			
			customerToUpdate.setCustomerName(customer.getCustomerName());
			customerToUpdate.setCustomerNip(customer.getCustomerNip());
			
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
						
			customerRepository.save(customerToUpdate);
			customerAdressRepository.save(customerAdressToUpdate);
			customerContactRepository.save(customerContactToUpdate);
			customerContractDetalisRepository.save(customerContractDetalisToUpdate);
			
		}
}
