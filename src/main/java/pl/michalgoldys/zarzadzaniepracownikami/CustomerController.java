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
		public String addingCustomers(Model model, @ModelAttribute Customer addingCustomer) {
			model.addAttribute("addingCustomer", new Customer());
			model.addAttribute("addingCustomer", new CustomerAdress());
			model.addAttribute("addingCustomer", new CustomerContractDetalis());
			
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		public String addingCustomersPost(@ModelAttribute Customer addingCustomer) {
			return "redirect:/customer/customerMenu";
		}
		
		@GetMapping(value="/customer/showingCustomerList")
		public String showingCustomerList() {
			return "showingCustomerList";
		}		
}