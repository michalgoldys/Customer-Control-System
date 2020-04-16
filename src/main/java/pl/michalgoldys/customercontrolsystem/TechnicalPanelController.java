package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
public class TechnicalPanelController {

    @Autowired
    CustomerTechnicalPanelDatabaseSaveService customerTechnicalPanelDatabaseSaveService;

    @Autowired
    FindCustomersReturnAsListServiceImpl findCustomersReturnAsListService;

    @Autowired
    FindByCustomerIdReturnAsTypeServiceImpl findByCustomerIdReturnAsTypeService;

    @GetMapping(value="/customer/customerTechnicalPanel")
    private String showingCustomerTechnicalPanel(Model model) {

        ArrayList<Customer> customerList = new ArrayList<>(findCustomersReturnAsListService.findAll());
        List<Integer> customerIssueCount = new ArrayList<>();
        List<String> customerLastIssueDateToSort = new ArrayList<>();
        List<String> customerLastIssueDateSorted = new ArrayList<>();

        Collections.sort(customerList, new CustomerSortByContractPdfId());

        customerList.forEach( c -> customerIssueCount.add(c.getCustomerTechnicalPanel().size()));
        customerList.forEach( c -> {
                    if(c.getCustomerTechnicalPanel().size() > 0) {
                        c.getCustomerTechnicalPanel().forEach( d -> customerLastIssueDateToSort.add(d.getCustomerTechnicalIssueOccurDate()));

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
    private String showingCustomerTechnicalDetails(@RequestParam("id") String customerSelectionId, Model model) {

        Customer selectedCustomer = findByCustomerIdReturnAsTypeService.findBy(customerSelectionId);

        model.addAttribute("isEmpty", selectedCustomer.getCustomerTechnicalPanel().isEmpty());
        model.addAttribute("selectedCustomerById", selectedCustomer);
        model.addAttribute("customerSelectionId", customerSelectionId);

        return "customerTechnicalDetails";
    }

    @GetMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetails/{customerSelectionId}/addingTechnicalEvent")
    private String showingFormTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId,
                                                                     CustomerTechnicalPanel customerTechnicalPanel, Model model) {

        Customer selectedCustomer = findByCustomerIdReturnAsTypeService.findBy(customerSelectionId);

        model.addAttribute("customerSelectionId", customerSelectionId);
        model.addAttribute("selectedCustomerById", selectedCustomer);

        return "addingTechnicalEvent";
    }

    @PostMapping(value="/customer/customerTechnicalPanel/customerTechnicalDetails/{customerSelectionId}/addingTechnicalEvent")
    private String creatingTechnicalEventToCustomerTechnicalPanel(@PathVariable String customerSelectionId,
                                                                  CustomerTechnicalPanel customerTechnicalPanel) {

        Customer selectedCustomer = findByCustomerIdReturnAsTypeService.findBy(customerSelectionId);
        CustomerWrapper objectToSave = new CustomerWrapper(selectedCustomer,customerTechnicalPanel);
        customerTechnicalPanelDatabaseSaveService.save(objectToSave);

        return"redirect:/customer/customerTechnicalPanel";
    }
}