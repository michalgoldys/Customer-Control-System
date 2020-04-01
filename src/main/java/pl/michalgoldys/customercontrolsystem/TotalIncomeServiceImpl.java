package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class TotalIncomeServiceImpl implements TotalIncomeInterface<Customer> {

    private int sum;

    @Override
    public Collection<Integer> totalIncome(Collection<Customer> customerList) {

        log.info("Counting total income of subscriptions for customer");

        List<Integer> sumOfIncomeBySubscriptions = new ArrayList<Integer>();

        for(Customer customer : customerList)
        {
            sum = 0;

            if(customer.getCustomerContractDetails().getCustomerPlSubscriptions() != null && customer.getCustomerContractDetails().getCustomerPlFee() != null
                    && customer.getCustomerContractDetails().getCustomerPlSubscriptions() > 0 && customer.getCustomerContractDetails().getCustomerPlFee() > 0)
            {
                sum += customer.getCustomerContractDetails().getCustomerPlSubscriptions() * customer.getCustomerContractDetails().getCustomerPlFee();
            }
            if(customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() != null && customer.getCustomerContractDetails().getCustomerPlUeFee() != null
                    && customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() > 0 && customer.getCustomerContractDetails().getCustomerPlUeFee() > 0)
            {
                sum += customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() * customer.getCustomerContractDetails().getCustomerPlUeFee();
            }
            if(customer.getCustomerContractDetails().getCustomerRuSubscriptions() != null && customer.getCustomerContractDetails().getCustomerRuFee() != null
                    && customer.getCustomerContractDetails().getCustomerRuSubscriptions() > 0 && customer.getCustomerContractDetails().getCustomerRuFee() > 0)
            {
                sum += customer.getCustomerContractDetails().getCustomerRuSubscriptions() * customer.getCustomerContractDetails().getCustomerRuFee();
            }
            sumOfIncomeBySubscriptions.add(sum);
        }

        return sumOfIncomeBySubscriptions;
    }
}
