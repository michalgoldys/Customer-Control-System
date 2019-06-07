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
		CustomerDatabaseService customerDatabaseService;
		
		@Autowired
		CustomerService customerSerivce;
		
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
			model.addAttribute("isDisabled", customerSerivce.settingActivationCheckbox(customerList));
			
			return "customerDetalis";
		}
		
		@PostMapping(value="/customer/showingCustomers/customerDetalis")
		private String updatingCustomerDetalis(@RequestParam("id") String customerSelectionId, 
				@Valid CustomerDTO customerDto, BindingResult customerBinding,
				@Valid CustomerAdressDTO customerAdressDto, BindingResult customerBinding1,
				@Valid CustomerContactDTO customerContactDto, BindingResult customerBinding2,
				Customer customer, CustomerAdress customerAdress, CustomerContact customerContact, Model model
				) {
			
			if (customerBinding.hasErrors()) 
			{
				return "customerDetalis";
			}
			
			customerDatabaseService.updatingCustomer(customer, customerAdress, customerContact, customerSelectionId);
			
			return "redirect:/customer/showingCustomers";
		}
		
		@GetMapping(value="/customer/showingCustomersBillings")
		private String showingCustomersBillings(Model model
				) {
			List<Customer> customerList =  customerDatabaseService.findAllCustomers();
			
			model.addAttribute("subSumAtr", customerSerivce.sumingSubscirptionPlUeRu(customerList));
			model.addAttribute("incomeSumValue", customerSerivce.sumOfIncomeBySubscriptions(customerList));
			model.addAttribute("sumOfCosts", customerSerivce.sumOfCosts(customerList));			
			model.addAttribute("customer", customerList);
			
			return "showingCustomersBillings";
		}
		
		@GetMapping(value="/customer/showingCustomersBillings/customerBillingDetalis")
		private String showingCustomerBillingDetalis(@RequestParam("id") String customerSelectionId, Model model)
		{
			List<Customer> customerList = customerDatabaseService.listFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("selectedCustomerById", customerList);	
			model.addAttribute("selectedCustomerId", customerSelectionId);
			
			return "customerBillingDetalis";
		}
		
		@PostMapping(value="/customer/showingCustomersBillings/customerBillingDetalis")
		private String updatingCustomerBillingDetalis(@RequestParam("id") String customerSelectionId,
				@Valid CustomerContractDetalisDTO customerContractDetalisDto, BindingResult bindingResult,
				CustomerContractDetalis customerContractDetalis
				) {
			if(bindingResult.hasErrors())
			{
				return "customerBillingDetalis";
			}
			
			customerDatabaseService.updatingCustomerBilling(customerContractDetalis);
			
			return "redirect:/customer/showingCustomersBillings";
		}
}