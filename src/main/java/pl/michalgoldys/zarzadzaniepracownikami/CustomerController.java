package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
		@GetMapping(value="/customer/customerTechnicalPanel")
		private String showingCustomerTechnicalPanel(Model model
				) {
			List<Customer> customerList =  customerDatabaseService.findAllCustomers();
			List<Integer> customerIssueCount = new ArrayList<Integer>();
			List<CustomerTechnicalPanel> customerLastIssueDate = new ArrayList<CustomerTechnicalPanel>();
			
			List<CustomerTechnicalPanel> customerLastIssueDateToSort = new ArrayList<CustomerTechnicalPanel>();
			List<CustomerTechnicalPanel> customerLastIssueDateSorted = new ArrayList<CustomerTechnicalPanel>(); 
			
			for(Customer customer : customerList)
			{
				customerIssueCount.add(customer.getCustomerTechnicalPanel().size());
			}
			
			for(Customer customer : customerList)
			{				
				customerLastIssueDateToSort.addAll(customer.getCustomerTechnicalPanel());
				
				for(CustomerTechnicalPanel customerIssueDate : customer.getCustomerTechnicalPanel())
				{
					customerLastIssueDateSorted.add(customerIssueDate);
				}
			}
			
			Collections.sort(customerLastIssueDateSorted, new CustomerTechnicalPanelSortByCustomerTechnicalIssueOccourDate());
			
			System.out.println("Rozmiar posortowanej tablcy: " + customerLastIssueDateSorted.size());
			
			for(CustomerTechnicalPanel customerTechnicalPanelList : customerLastIssueDateSorted)
			{
				System.out.println("PosortowanaData: " + customerTechnicalPanelList.getCustomerTechnicalIssueOccourDate());
				
				//customerLastIssueDate.add(customerLastIssueDateSorted.get(0));
			}
			
			for(CustomerTechnicalPanel customerTechnicalPanelList : customerLastIssueDate)
			{
				System.out.println("Data Ostatniego Zgloszenia: " + customerTechnicalPanelList.getCustomerTechnicalIssueOccourDate());
			}
			
			//model.addAttribute("customerLastIssueDate", customerLastIssueDate);
			model.addAttribute("customerIssueCount", customerIssueCount);
			model.addAttribute("customer", customerList);
			
			return "customerTechnicalPanel";
		}
		
		@GetMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetalis")
		private String showingCustomerTechnicalDetalis(@RequestParam("id") String customerSelectionId, Model model
				) {
			
			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);
			
			boolean isEmpty = selectedCustomer.getCustomerTechnicalPanel().isEmpty();
			
			model.addAttribute("isEmpty", isEmpty);
			model.addAttribute("selectedCustomerById", selectedCustomer);
			model.addAttribute("customerSelectionId", customerSelectionId);
			
			return "customerTechnicalDetalis";
		}
		
		@GetMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetalis/{customerSelectionId}/addingTechnicalEvent")
		private String showingFormTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId, 
				CustomerTechnicalPanel customerTechnicalPanel, Model model)
		{
			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("customerSelectionId", customerSelectionId);
			model.addAttribute("selectedCustomerById", selectedCustomer);
			
			return "addingTechnicalEvent";
		}
		
		@PostMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetalis/{customerSelectionId}/addingTechnicalEvent")
		private String creatingTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId, 
				CustomerTechnicalPanel customerTechnicalPanel)
		{
			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);

			customerDatabaseService.creatingCustomerTechnicalPanelEntity(selectedCustomer, customerTechnicalPanel);
			
			return"customerTechnicalPanel";
		}
}