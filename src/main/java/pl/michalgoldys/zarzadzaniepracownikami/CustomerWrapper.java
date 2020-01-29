package pl.michalgoldys.zarzadzaniepracownikami;

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

    private CustomerWrapper(Customer customer, CustomerAddress customerAddress, CustomerContractDetails customerContractDetails, CustomerContact customerContact) {
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.customerContractDetails = customerContractDetails;
        this.customerContact = customerContact;
    }

    private CustomerWrapper(){

    }

    public CustomerWrapper customerWrapperService(Customer customer, CustomerAddress customerAddress,
                                                  CustomerContractDetails customerContractDetails, CustomerContact customerContact){

        log.info("Wrapping Customer data: " + customer.toString()+ customerAddress.toString() + customerContact.toString() + customerContractDetails.toString());

        CustomerWrapper customerWrapper = new CustomerWrapper(customer, customerAddress,
                customerContractDetails, customerContact);

        return customerWrapper;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerContractDetails getCustomerContractDetails() {
        return customerContractDetails;
    }

    public void setCustomerContractDetails(CustomerContractDetails customerContractDetails) {
        this.customerContractDetails = customerContractDetails;
    }

    public CustomerContact getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(CustomerContact customerContact) {
        this.customerContact = customerContact;
    }
}