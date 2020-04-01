package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class TotalSubscriptionsServiceImpl implements TotalSubscriptionsInterface<Customer> {

    private int sum;

    @Override
    public Collection<Integer> totalSubscriptionsIncome(Collection<Customer> customerList) {

        log.info("Calculating total subscriptions for each customer object..");

        List<Integer> customerSubscriptionsSum = new ArrayList<>();

        customerList.forEach(c -> {
            sum = 0;
            if(c.getCustomerContractDetails().getCustomerPlSubscriptions() != null) {
                sum += c.getCustomerContractDetails().getCustomerPlSubscriptions();
            }
            if(c.getCustomerContractDetails().getCustomerPlUeSubscriptions() != null)
            {
                sum += c.getCustomerContractDetails().getCustomerPlUeSubscriptions();
            }
            if(c.getCustomerContractDetails().getCustomerRuSubscriptions() != null)
            {
                sum += c.getCustomerContractDetails().getCustomerRuSubscriptions();
            }
            customerSubscriptionsSum.add(sum);
        });

        return customerSubscriptionsSum;
    }
}
