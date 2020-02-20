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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {

		@Autowired
		IsActiveableValidatorServiceImpl isActiveableValidatorService;

		@Autowired
		CustomerSpecificationExecutorRepository customerSpecificationExecutorRepository;
		
		@Autowired
		CustomerDatabaseSaveService customerDatabaseSaveService;

		@Autowired
		CustomerDatabaseUpdateService customerDatabaseUpdateService;

		@Autowired
		CustomerWrapper customerWrapper;

		@Autowired
		FindByCustomerIdReturnAsTypeServiceImpl findByCustomerIdReturnAsTypeService;

		@Autowired
		FindCustomersReturnAsListServiceImpl findCustomersReturnAsListService;

		@Autowired
		FindCustomersReturnAsPageServiceImpl findCustomersReturnAsPageService;
		
		@GetMapping(value="/customer/showingCustomers")
		private String showingCustomers(Model model, @RequestParam(defaultValue="0") Integer page,
										@RequestParam(required=false) String sort, @RequestParam(required=false) String query) {
			boolean isNext;
			boolean isPrevious;

			if(page == null) {
				page = 0;
			}

			if(page > 0) {
				isPrevious = true;
			}
			else {
				isPrevious = false;
			}

			model.addAttribute("page", page);
			model.addAttribute("sort", sort);
			model.addAttribute("query", query);

			if(query == null){
				model.addAttribute("customer", findCustomersReturnAsListService.findAll());
			}
			else if(query.isEmpty()) {
				Page<Customer> customerToShow = findCustomersReturnAsPageService.findAll(PageRequest.of(page, 2, Sort.by(sort)));

				if(page < customerToShow.getTotalPages()-1) {
					isNext = true;
				}
				else {
					isNext = false;
				}

				model.addAttribute("isPrevious", isPrevious);
				model.addAttribute("isNext", isNext);
				model.addAttribute("customer", customerToShow);
			}
			else {
				List<Customer> customerToShowQuery = customerSpecificationExecutorRepository.findAll(Specification.where(CustomerSpecificationSearchImplementation.textInAllColumns(query)));
				model.addAttribute("customer", customerToShowQuery);
			}

			return "showingCustomers";
			
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
			Customer customerEntity = findByCustomerIdReturnAsTypeService.findBy(customerSelectionId);
			
			model.addAttribute("selectedCustomerId", customerSelectionId);
			model.addAttribute("selectedCustomerById", customerEntity);
			model.addAttribute("isDisabled", isActiveableValidatorService.isActiveableChecker(customerEntity));
			
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

}