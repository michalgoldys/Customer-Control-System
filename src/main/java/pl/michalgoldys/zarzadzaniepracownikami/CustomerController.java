package pl.michalgoldys.zarzadzaniepracownikami;

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
		private CustomerDatabaseService customerDatabaseService;
		
		@GetMapping(value= "/customer/customerMenu")
		private String customerMenu(
				) {
			return "customerMenu";
		}
		
		@GetMapping(value="/customer/showingCustomers")
		private String showingCustomers(Model model
				) {
			
			model.addAttribute("customer", customerDatabaseService.findAllCustomers());
			
			return "showingCustomers";
		}
		
		@GetMapping(value="/customer/addingCustomer")
		private String addingCustomersForm(
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis,
				CustomerDTO customerDto, CustomerAdressDTO customerAdressDto, CustomerContactDTO customerContactDto, 
				CustomerContractDetalisDTO customerContractDetalisDto
				) {
			 
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		private String addingCustomers(
				@Valid CustomerDTO customerDto, BindingResult customerBinding,
				@Valid CustomerAdressDTO customerAdressDto, BindingResult customerBinding1,
				@Valid CustomerContactDTO customerContactDto, BindingResult customerBinding2, 
				@Valid CustomerContractDetalisDTO customerContractDetalisDto, BindingResult customerBinding3,
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis
				) {
				
			if (customerBinding.hasErrors()) {
					return "addingCustomer";
				}
			
			customer.setCustomerIsActive(false);
			customerDatabaseService.creatingCustomer(customer, customerAdress, customerContact, customerContractDetalis);

			return "redirect:/customer/customerMenu";
			
		}
		
		@GetMapping(value="/customer/showingCustomers/customerDetalis")
		private String showingCustomerDetalis(@RequestParam("id") String customerSelectionId, Model model
				) {
			List<Customer> customerList = customerDatabaseService.listFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("selectedCustomerId", customerSelectionId);
			model.addAttribute("selectedCustomerById", customerList);
			
			boolean isDisabled = false;
			
			for(Customer customer : customerList) {
			
				if(customer.getCustomerActivationDate() != null && customer.getCustomerActivationDate().length() > 0 
						&& customer.getCustomerDeactivationDate() != null && customer.getCustomerDeactivationDate().length() > 0){
					
					isDisabled = true;
				}
			}
			
			model.addAttribute("isDisabled", isDisabled);
			
			
			return "customerDetalis";
		}
		
		@PostMapping(value="/customer/showingCustomers/customerDetalis")
		private String settingCustomerDetalis(@RequestParam("id") String customerSelectionId, 
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, CustomerContractDetalis customerContractDetalis, 
				Model model
				) {
						
			customerDatabaseService.updatingCustomer(customer, customerAdress, customerContact, customerContractDetalis, customerSelectionId);
			
			return "redirect:/customer/showingCustomers";
		}
		
		@GetMapping(value="/customer/showingCustomersBillings")
		private String showingCustomersBillings(Model model
				) {
			
			model.addAttribute("customer", customerDatabaseService.findAllCustomers());
			
			return "showingCustomersBillings";
		}
}