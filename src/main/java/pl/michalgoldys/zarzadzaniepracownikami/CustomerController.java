package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
		@Autowired
		CustomerRepository customerRepository;
		
		@Autowired
		CustomerRepositoryImp customerRepositoryImp;
		
		@Autowired
		CustomerAdressRepository customerAdressRepository;
		
		@Autowired
		CustomerContactRepository customerContactRepository;
	
		@Autowired 
		CustomerDatabaseService customerDatabaseService;
		
		@GetMapping(value= "/customer/customerMenu")
		public String customerMenu() {
			return "customerMenu";
		}
		
		@GetMapping(value="/customer/showingCustomers")
		public String showingCustomers(Model model) {
			
			model.addAttribute("customer", customerRepository.findAll());
			
			return "showingCustomers";
		}
		
		@GetMapping(value="/customer/addingCustomer")
		public String addingCustomersForm(
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis,
				CustomerDTO customerDto, CustomerAdressDTO customerAdressDto, CustomerContactDTO customerContactDto, 
				CustomerContractDetalisDTO customerContractDetalisDto) {
			 
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		public String addingCustomers(
				@Valid CustomerDTO customerDto, BindingResult customerBinding,
				@Valid CustomerAdressDTO customerAdressDto, BindingResult customerBinding1,
				@Valid CustomerContactDTO customerContactDto, BindingResult customerBinding2, 
				@Valid CustomerContractDetalisDTO customerContractDetalisDto, BindingResult customerBinding3,
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis) {
				
			if (customerBinding.hasErrors()) {
					return "addingCustomer";
				}
			
			customerAdress.setCustomer(customer);
			customer.setCustomerAdress(customerAdress);
			customerContact.setCustomer(customer);
			
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customer.setCustomerContact(customerContactList);
			
			
			customerContractDetalis.setCustomer(customer);
			customer.setCustomerContractDetalis(customerContractDetalis);
			
			customerRepository.save(customer);

			return "redirect:/customer/customerMenu";
			
		}
		
		@GetMapping(value="/customer/showingCustomers/customerDetalis")
		public String showingCustomerDetalis(@RequestParam("id") String customerSelectionId, Model model,
				Customer customer
				) {
			
			model.addAttribute("selectedCustomerId", customerSelectionId);
			model.addAttribute("selectedCustomerById", customerRepository.findBycustomerContractPdfId(customerSelectionId));
			
			return "customerDetalis";
		}

		
		@PostMapping(value="/customer/showingCustomers/customerDetalis")
		public String settingCustomerDetalis(@RequestParam("id") String customerSelectionId, 
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis, 
				Model model
				) {
			/*
			Customer customerToUpdate = new Customer();
			customerToUpdate = customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId);
			
			customerToUpdate.setCustomerAdress(customerAdress);
			customerToUpdate.setCustomerContractDetalis(customerContractDetalis);
			customerToUpdate.setCustomerNip(customer.getCustomerNip());
			customerToUpdate.setCustomerName(customer.getCustomerName());
			
			//Customer customerPdfIdUpdate = customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId);
			//Long customerId = customerPdfIdUpdate.getCustomerId();
			
			//Customer customerUpdate = customerRepositoryImp.getOne(customerId);
			
			// CustomerAdress customerAdressUpate = customerAdressRepository.findBycustomerAdressId(customerId);
			// List <Customer> customerUpdate = customerRepository.findBycustomerId(customerId);
			


			/*
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customerPdfIdUpdate.setCustomerContact(customerContactList);
			
			customerPdfIdUpdate.setCustomerContractDetalis(customerContractDetalis);
			*/
			
			customerDatabaseService.updateCostumer(customer, customerAdress, customerContact, customerContractDetalis, customerSelectionId);
			
			/*
			Customer customerToUpdate = customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId);
			
			customer.setCustomerId(customerToUpdate.getCustomerId());
			customerAdress.setCustomer(customer);
			customer.setCustomerAdress(customerAdress);
			customerContact.setCustomer(customer);
			
			
			List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
			customerContactList.add(customerContact);
			
			customer.setCustomerContact(customerContactList);
			
			
			customerContractDetalis.setCustomer(customer);
			customer.setCustomerContractDetalis(customerContractDetalis);

			customerRepository.save(customer);
			*/
			
			return "redirect:/customer/showingCustomers";
		}
}