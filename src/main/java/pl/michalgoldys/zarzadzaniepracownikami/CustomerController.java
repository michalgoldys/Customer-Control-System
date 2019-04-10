package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	
		@Autowired
		CustomerRepository customerRepository;
		
		@Autowired
		CustomerAdressRepository customerAdressRepository;
		
		@Autowired
		CustomerContactRepository customerContactRepository;
	
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
		public String addingCustomersForm(Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis) {
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		public String addingCustomers(
				@Valid CustomerDTO customerDTO, @Valid CustomerAdressDTO customerAdressDTO, @Valid CustomerContactDTO customerContactDTO, @Valid CustomerContractDetalisDTO customerContractDetalisDTO, BindingResult bindingResult,
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis) {
				
	
			if (bindingResult.hasErrors()) {
					return "/customer/addingCustomer";
				}
			else
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

			return "redirect:/customerMenu";
			}
		}
		
		@GetMapping(value="/customer/customerDetalis")
		public String showingCustomerDetalis() {
			
			return "customerDetalis";
		}
		
		@PostMapping(value="customer/customerDetalis")
		public String settingCustomerDetalis() {
			
			return "customerMenu";
		}
}