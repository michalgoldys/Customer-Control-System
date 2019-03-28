package pl.michalgoldys.zarzadzaniepracownikami;

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
		
		@GetMapping(value="/customer/showingCustomer")
		public String showingCustomers() {
			return "showingCustomers";
		}
		
		@GetMapping(value="/customer/addingCustomer")
		public String addingCustomersForm(Model model) {
			
			model.addAttribute("customer", new Customer());
			model.addAttribute("customerAdress", new CustomerAdress());
			model.addAttribute("customerContact", new CustomerContact());
			
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		public String addingCustomers(@Valid CustomerDTO customerDTO, @Valid CustomerAdressDTO customerAdressDTO, @Valid CustomerContactDTO customerContactDTO, BindingResult result, 
				@ModelAttribute Customer customer, @ModelAttribute CustomerAdress customerAdress, @ModelAttribute CustomerContact customerContact) {
				
			
			if (result.hasErrors()) {
					return "addingCustomer";
				}
			
			customer.addCustomerAdress(customerAdress);
			customer.addCustomerContact(customerContact);
			
			customerRepository.save(customer);
			customerAdressRepository.save(customerAdress);
			customerContactRepository.save(customerContact);
			return "customerMenu";
		}
		
		@GetMapping(value="/customer/showingCustomerList")
		public String showingCustomerList() {
			return "showingCustomerList";
		}		
}