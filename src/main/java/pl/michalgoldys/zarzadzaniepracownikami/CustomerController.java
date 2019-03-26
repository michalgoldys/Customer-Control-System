package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	
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
			model.addAttribute("addingCustomer", new Customer());
			model.addAttribute("addingCustomerAdress", new CustomerAdress());
			model.addAttribute("addingCustomerContact", new CustomerContact());
			
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		public String addingCustomers(@ModelAttribute Customer addingCustomer) {
			return "customerMenu";
		}
		
		@GetMapping(value="/customer/showingCustomerList")
		public String showingCustomerList() {
			return "showingCustomerList";
		}		
}