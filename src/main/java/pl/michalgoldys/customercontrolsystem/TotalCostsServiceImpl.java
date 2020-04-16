package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class TotalCostsServiceImpl implements TotalCostsInterface<Customer> {

    private final double serverCost = 10;
    private final double telematicCardCost = 2.50d;

    private double costSum ;

    @Override
    public Collection<Double> totalCosts(Collection<Customer> customerList) {

        List<Double> sumOfCosts = new ArrayList<>();

        for(Customer customer : customerList) {

            if(customer.getCustomerContractDetails().getCustomerPlSubscriptions() != null &&
                    customer.getCustomerContractDetails().getCustomerPlSubscriptions() > 0) {

                costSum += customer.getCustomerContractDetails().getCustomerPlSubscriptions() * serverCost;
                costSum += customer.getCustomerContractDetails().getCustomerPlSubscriptions() * telematicCardCost;
            }

            if(customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() != null &&
                    customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() > 0) {

                costSum += customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() * serverCost;
                costSum += customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() * telematicCardCost;
            }

            if(customer.getCustomerContractDetails().getCustomerRuSubscriptions() != null &&
                    customer.getCustomerContractDetails().getCustomerRuSubscriptions() > 0) {

                costSum += customer.getCustomerContractDetails().getCustomerRuSubscriptions() * serverCost;
                costSum += customer.getCustomerContractDetails().getCustomerRuSubscriptions() * telematicCardCost;
            }

            sumOfCosts.add(costSum);
        }

        return sumOfCosts;
    }
}