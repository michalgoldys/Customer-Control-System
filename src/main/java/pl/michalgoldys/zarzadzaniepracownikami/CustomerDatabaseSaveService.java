package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerDatabaseSaveService implements DatabaseGenericSave<CustomerWrapper> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(CustomerWrapper customerWrapper) {

        log.info("Customer Wrapper Object: " + customerWrapper.toString());

        Customer customer = new Customer();
        CustomerAddress customerAddress = new CustomerAddress();
        CustomerContractDetails customerContractDetails = new CustomerContractDetails();
        CustomerContact customerContact = new CustomerContact();

        customer = customerWrapper.getCustomer();
        customerAddress = customerWrapper.getCustomerAddress();
        customerContractDetails = customerWrapper.getCustomerContractDetails();
        customerContact = customerWrapper.getCustomerContact();

        log.info("Service status: " + customer.toString()+ customerAddress.toString() + customerContact.toString() + customerContractDetails.toString());

        customerAddress.setCustomer(customer);
        customer.setCustomerAddress(customerAddress);
        customerContact.setCustomer(customer);

        List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
        customerContactList.add(customerContact);

        customer.setCustomerContact(customerContactList);

        customerContractDetails.setCustomer(customer);
        customer.setCustomerContractDetails(customerContractDetails);

        customerRepository.save(customer);


    }
}
