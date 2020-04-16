package pl.michalgoldys.customercontrolsystem;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@ToString
@Slf4j
public class CustomerWrapper {

    private Customer customer;
    private CustomerAddress customerAddress;
    private CustomerContractDetails customerContractDetails;
    private CustomerContact customerContact;
    private CustomerTechnicalPanel customerTechnicalPanel;

    public CustomerWrapper(Customer customer, CustomerAddress customerAddress, CustomerContractDetails customerContractDetails, CustomerContact customerContact) {
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.customerContractDetails = customerContractDetails;
        this.customerContact = customerContact;
    }

    public CustomerWrapper(Customer customer, CustomerAddress customerAddress, CustomerContact customerContact) {
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
    }

    public CustomerWrapper(Customer customer, CustomerTechnicalPanel customerTechnicalPanel) {
        this.customer = customer;
        this.customerTechnicalPanel = customerTechnicalPanel;
    }

    private CustomerWrapper(){
    }

    public CustomerTechnicalPanel getCustomerTechnicalPanel() {
        return customerTechnicalPanel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public CustomerContractDetails getCustomerContractDetails() {
        return customerContractDetails;
    }

    public CustomerContact getCustomerContact() {
        return customerContact;
    }
}