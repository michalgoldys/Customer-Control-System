package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {

		@Autowired
		CustomerDatabaseService customerDatabaseService;

		@Autowired
		CustomerSpecificationExecutorRepository customerSpecificationExecutorRepository;
		
		@Autowired
		CustomerService customerService;

		@Autowired
		CustomerDatabaseSaveService customerDatabaseSaveService;

		@Autowired
		CustomerDatabaseUpdateService customerDatabaseUpdateService;

		@Autowired
		CustomerContractDatabaseUpdateService customerContractDatabaseUpdateService;

		@Autowired
		CustomerWrapper customerWrapper;

		@Autowired
		CustomerTechnicalPanelDatabaseSaveService customerTechnicalPanelDatabaseSaveService;

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
				List<Customer> customerToShowQuery = customerSpecificationExecutorRepository.findAll(Specification.where(CustomerSpecificationSearchImplementation.textInAllColumns(query)));
				model.addAttribute("customer", customerToShowQuery);
			}
			
			return "showingCustomers";
		}
		
		@GetMapping(value="/customer/addingCustomer")
		private String addingCustomersForm(
				Customer customer, CustomerAddress customerAddress, CustomerContact customerContact, CustomerContractDetails customerContractDetails,
				CustomerDTO customerDto, CustomerAddressDTO customerAddressDto, CustomerContactDTO customerContactDto,
				CustomerContractDetailsDTO customerContractDetailsDto
				) {
			 
			return "addingCustomer";
		}
		
		@PostMapping(value="/customer/addingCustomer")
		private String addingCustomers(
				@Valid CustomerDTO customerDto, BindingResult customerBinding,
				@Valid CustomerAddressDTO customerAddressDto, BindingResult customerBinding1,
				@Valid CustomerContactDTO customerContactDto, BindingResult customerBinding2,
				@Valid CustomerContractDetailsDTO customerContractDetailsDto, BindingResult customerBinding3,
				Customer customer, CustomerAddress customerAddress, CustomerContact customerContact, CustomerContractDetails customerContractDetails
				) {
				
			if (customerBinding.hasErrors()) {
					return "addingCustomer";
				}

			log.info("Controller data: " + customer.toString()+ customerAddress.toString() + customerContact.toString() + customerContractDetails.toString());

			customer.setCustomerIsActive(false);
			CustomerWrapper toSave = customerWrapper.customerWrapperService(customer, customerAddress, customerContractDetails, customerContact);

			log.info("Customer Wrapper Object Contains: " + toSave.toString());

			customerDatabaseSaveService.save(toSave);

			return "redirect:/customer/customerMenu";

		}
		
		@GetMapping(value="/customer/showingCustomers/customerDetails")
		private String showingCustomerDetails(@RequestParam("id") String customerSelectionId, Model model
				) {
			List<Customer> customerList = customerDatabaseService.listFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("selectedCustomerId", customerSelectionId);
			model.addAttribute("selectedCustomerById", customerList);			
			model.addAttribute("isDisabled", customerService.isActivationCheckboxActive(customerList));
			
			return "customerDetails";
		}
		
		@PostMapping(value="/customer/showingCustomers/customerDetails")
		private String updatingCustomerDetails(@RequestParam("id") String customerSelectionId,
											   @Valid CustomerDTO customerDto, BindingResult customerBinding,
											   @Valid CustomerAddressDTO customerAddressDto, BindingResult customerBinding1,
											   @Valid CustomerContactDTO customerContactDto, BindingResult customerBinding2,
											   Customer customer, CustomerAddress customerAddress, CustomerContact customerContact, Model model
				) {
			
			if (customerBinding.hasErrors()) 
			{
				return "customerDetails";
			}

			CustomerWrapper toUpdate = new CustomerWrapper(customer, customerAddress, customerContact);
			customerDatabaseUpdateService.update(toUpdate);

			return "redirect:/customer/showingCustomers";
		}
		
		@GetMapping(value="/customer/showingCustomersBillings")
		private String showingCustomersBillings(Model model
				) {
			List<Customer> customerList =  customerDatabaseService.findAllCustomers();
			
			model.addAttribute("subSumAtr", customerService.subscriptionSum(customerList));
			model.addAttribute("incomeSumValue", customerService.incomeSubscriptionSum(customerList));
			model.addAttribute("sumOfCosts", customerService.costsSum(customerList));
			model.addAttribute("customer", customerList);
			
			return "showingCustomersBillings";
		}
		
		@GetMapping(value="/customer/showingCustomersBillings/customerBillingDetails")
		private String showingCustomerBillingDetails(@RequestParam("id") String customerSelectionId, Model model)
		{
			List<Customer> customerList = customerDatabaseService.listFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("selectedCustomerById", customerList);	
			model.addAttribute("selectedCustomerId", customerSelectionId);
			
			return "customerBillingDetails";
		}
		
		@PostMapping(value="/customer/showingCustomersBillings/customerBillingDetails")
		private String updatingCustomerBillingDetails(@RequestParam("id") String customerSelectionId,
													  @Valid CustomerContractDetailsDTO customerContractDetailsDto, BindingResult bindingResult,
													  CustomerContractDetails customerContractDetails
				) {

			if(bindingResult.hasErrors())
			{
				return "customerBillingDetails";
			}

			log.info("Recrived object to persist: " + customerContractDetails);

			customerContractDatabaseUpdateService.update(customerContractDetails);

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

			model.addAttribute("customerLastIssueDate", customerLastIssueDateSorted);
			model.addAttribute("customerIssueCount", customerIssueCount);
			model.addAttribute("customer", customerList);
			
			return "customerTechnicalPanel";
		}
		
		@GetMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetails")
		private String showingCustomerTechnicalDetails(@RequestParam("id") String customerSelectionId, Model model
				) {
			
			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);
			
			boolean isEmpty = selectedCustomer.getCustomerTechnicalPanel().isEmpty();
			
			model.addAttribute("isEmpty", isEmpty);
			model.addAttribute("selectedCustomerById", selectedCustomer);
			model.addAttribute("customerSelectionId", customerSelectionId);
			
			return "customerTechnicalDetails";
		}
		
		@GetMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetails/{customerSelectionId}/addingTechnicalEvent")
		private String showingFormTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId, 
				CustomerTechnicalPanel customerTechnicalPanel, Model model)
		{
			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);
			
			model.addAttribute("customerSelectionId", customerSelectionId);
			model.addAttribute("selectedCustomerById", selectedCustomer);
			
			return "addingTechnicalEvent";
		}
		
		@PostMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetails/{customerSelectionId}/addingTechnicalEvent")
		private String creatingTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId, 
				CustomerTechnicalPanel customerTechnicalPanel)
		{

			Customer selectedCustomer = customerDatabaseService.customerFindByCustomerContractPdfId(customerSelectionId);
			CustomerWrapper objectToSave = new CustomerWrapper(selectedCustomer,customerTechnicalPanel);
			customerTechnicalPanelDatabaseSaveService.save(objectToSave);
			
			return"redirect:/customerTechnicalPanel";
		}
}