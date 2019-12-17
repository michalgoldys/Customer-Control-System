package pl.michalgoldys.zarzadzaniepracownikami;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
		CustomerRepository customerRepository;
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		CustomerJpaRepository customerJpaRepository;

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
		
		@GetMapping(value="/customer/showingCustomersInteractive")
		private String showingCustomersInteractive(Model model, @RequestParam(defaultValue="0") Integer page, 
				@RequestParam(required=false) String sort, @RequestParam(required=false) String query)
		{
			boolean isNext;
			boolean isPrevious;
			
			if(page == null)
			{
				page = 0;
			}
			
			if(page > 0)
			{
				isPrevious = true;
			}
			else
			{
				isPrevious = false;
			}
						
			model.addAttribute("page", page);
			model.addAttribute("sort", sort);
			model.addAttribute("query", query);
			
			if(query.isEmpty())
			{
				Page<Customer> customerToShow = customerDatabaseService.findAllCustomers(PageRequest.of(page, 2, Sort.by(sort)));
				
				if(page < customerToShow.getTotalPages()-1)
				{
					isNext = true;
				}
				else
				{
					isNext = false;
				}
				
				model.addAttribute("isPrevious", isPrevious);
				model.addAttribute("isNext", isNext);
				model.addAttribute("customer", customerToShow);
			}
			else
			{
				List<Customer> customerToShowQuery = customerRepository.findAll(Specification.where(CustomerSpecification.textInAllColumns(query)));
				model.addAttribute("customer", customerToShowQuery);
			}
			
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
			model.addAttribute("isDisabled", customerService.isActivationCheckboxActive(customerList));
			
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
			
			model.addAttribute("subSumAtr", customerService.subscritionSum(customerList));
			model.addAttribute("incomeSumValue", customerService.incomeSubscriptionSum(customerList));
			model.addAttribute("sumOfCosts", customerService.costsSum(customerList));
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
			List<String> customerLastIssueDateToSort = new ArrayList<String>();
			List<String> customerLastIssueDateSorted = new ArrayList<String>(); 
			
			Collections.sort(customerList, new CustomerSortByContractPdfId());
			
			customerList.forEach( c -> customerIssueCount.add(c.getCustomerTechnicalPanel().size()));
			customerList.forEach( c -> {
				if(c.getCustomerTechnicalPanel().size() > 0) {
					c.getCustomerTechnicalPanel().forEach( d -> customerLastIssueDateToSort.add(d.getCustomerTechnicalIssueOccourDate()));
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					
					Comparator<String> compareIssueDate = (String s1, String s2) -> 
					LocalDate.parse(s1, formatter).compareTo(LocalDate.parse(s2, formatter));
					
					customerLastIssueDateToSort.sort(compareIssueDate);
					customerLastIssueDateSorted.add(customerLastIssueDateToSort.get(customerLastIssueDateToSort.size()-1));
					
					customerLastIssueDateToSort.clear();
				}
				else
				{
					customerLastIssueDateSorted.add("NULL");
				}
				}
			);

			System.out.println("Rozmiar posortowanej tablcy: " + customerLastIssueDateSorted.size());

			customerLastIssueDateSorted.forEach(customerTechnicalPanelList -> System.out.println("PosortowanaData: " + customerTechnicalPanelList));
			
			model.addAttribute("customerLastIssueDate", customerLastIssueDateSorted);
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