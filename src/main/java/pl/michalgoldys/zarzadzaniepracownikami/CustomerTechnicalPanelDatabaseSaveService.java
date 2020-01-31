package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerTechnicalPanelDatabaseSaveService implements DatabaseGenericSave<CustomerWrapper> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(CustomerWrapper customerWrapper) {

        Customer selectedCustomer = customerWrapper.getCustomer();
        CustomerTechnicalPanel customerTechnicalPanel = customerWrapper.getCustomerTechnicalPanel();

        CustomerTechnicalPanel newCustomerTechnicalPanel = new CustomerTechnicalPanel();

        newCustomerTechnicalPanel.setCustomerTechnicalIssueDescribtion(customerTechnicalPanel.getCustomerTechnicalIssueDescribtion());
        newCustomerTechnicalPanel.setCustomerTechnicalIssueOccourDate(customerTechnicalPanel.getCustomerTechnicalIssueOccourDate());

        newCustomerTechnicalPanel.setCustomer(selectedCustomer);

        List<CustomerTechnicalPanel> customerTechnicalPanelList = new ArrayList<CustomerTechnicalPanel>();
        customerTechnicalPanelList.add(newCustomerTechnicalPanel);

        selectedCustomer.setCustomerTechnicalPanel(customerTechnicalPanelList);

        customerRepository.save(selectedCustomer);
    }
}
