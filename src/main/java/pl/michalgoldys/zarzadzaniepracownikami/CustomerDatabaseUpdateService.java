package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerDatabaseUpdateService implements DatabaseGenericUpdate<CustomerWrapper> {

    @Autowired
    DateServiceImpl dateService;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void update(CustomerWrapper customerWrapper) {

        log.info("Customer Wrapper Object: " + customerWrapper.toString());

        Customer customer = customerWrapper.getCustomer();
        CustomerAddress customerAddress = customerWrapper.getCustomerAddress();
        CustomerContact customerContact = customerWrapper.getCustomerContact();

        log.info("Service status: " + customer.toString()+ customerAddress.toString() + customerContact.toString());

        Boolean isActive = customer.getCustomerIsActive();
        String activationDate = customer.getCustomerActivationDate();
        String deactivationDate = customer.getCustomerDeactivationDate();

        if (isActive && activationDate.length() == 0) {
            customer.setCustomerActivationDate(dateService.getCurrentDate());
        }

        if (!isActive && activationDate != null && activationDate.length() > 0 && deactivationDate.length() == 0) {
            customer.setCustomerDeactivationDate(dateService.getCurrentDate());
        }
       
        customer.setCustomerAddress(customerAddress);
        customerAddress.setCustomer(customer);

        List<CustomerContact> customerContactList = new ArrayList<CustomerContact>();
        customerContactList.add(customerContact);

        customer.setCustomerContact(customerContactList);
        customerContact.setCustomer(customer);

        log.info("About to update ID: " + customer.getCustomerId());

        customerRepository.save(customer);
    }
}
