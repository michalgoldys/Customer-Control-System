package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Slf4j
@Controller
public class BillingDetailsController {

    @Autowired
    TotalCostsServiceImpl totalCostsService;

    @Autowired
    TotalIncomeServiceImpl totalIncomeService;

    @Autowired
    TotalSubscriptionsServiceImpl totalSubscriptionsService;

    @Autowired
    CustomerContractDatabaseUpdateService customerContractDatabaseUpdateService;

    @Autowired
    FindByCustomerIdReturnAsTypeServiceImpl findByCustomerIdReturnAsTypeService;

    @Autowired
    FindCustomersReturnAsListServiceImpl findCustomersReturnAsListService;


    @GetMapping(value="/customer/showingCustomersBillings")
    private String showingCustomersBillings(Model model
    ) {
        ArrayList<Customer> customerList = new ArrayList<>(findCustomersReturnAsListService.findAll());

        model.addAttribute("subSumAtr", totalSubscriptionsService.totalSubscriptionsIncome(customerList));
        model.addAttribute("incomeSumValue", totalIncomeService.totalIncome(customerList));
        model.addAttribute("sumOfCosts", totalCostsService.totalCosts(customerList));
        model.addAttribute("customer", customerList);

        return "showingCustomersBillings";
    }

    @GetMapping(value="/customer/showingCustomersBillings/customerBillingDetails")
    private String showingCustomerBillingDetails(@RequestParam("id") String customerSelectionId, Model model)
    {
        Customer customerEntity = findByCustomerIdReturnAsTypeService.findBy(customerSelectionId);

        model.addAttribute("selectedCustomerById", customerEntity);
        model.addAttribute("selectedCustomerId", customerSelectionId);

        return "customerBillingDetails";
    }

    @PostMapping(value="/customer/showingCustomersBillings/customerBillingDetails")
    private String updatingCustomerBillingDetails(@RequestParam("id") String customerSelectionId,
                                                  @Valid CustomerContractDetailsDTO customerContractDetailsDto, BindingResult bindingResult,
                                                  CustomerContractDetails customerContractDetails
    ) {

        if(bindingResult.hasErrors()) {
            return "customerBillingDetails";
        }

        log.info("Received object to persist: " + customerContractDetails);

        customerContractDatabaseUpdateService.update(customerContractDetails);

        return "redirect:/customer/showingCustomersBillings";
    }

}