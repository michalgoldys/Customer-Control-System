package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IsActiveableValidatorServiceImpl implements IsActiveableValidatorInterface<Customer> {

    @Override
    public Boolean isActiveableChecker(Customer customer) {

        log.info("Checking if its possible to mark customer entity as active, and inactive");

        return customer.getCustomerActivationDate() != null && customer.getCustomerActivationDate().length() > 0
                && customer.getCustomerDeactivationDate() != null && customer.getCustomerDeactivationDate().length() > 0;
    }
}
