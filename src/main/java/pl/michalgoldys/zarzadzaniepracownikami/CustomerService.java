package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

	int serverCost = 10;
	double telematicCardCost = 2.50d;

		int sum;
		double costSum;

		public List<Integer> subscriptionSum(List<Customer> customerList)
		{
			List<Integer> customerSubstripctionsSum = new ArrayList<Integer>();

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
				customerSubstripctionsSum.add(sum);
			});

			return customerSubstripctionsSum;
		}

	public Boolean isActivationCheckboxActive(Customer customer)
	{
		if(customer.getCustomerActivationDate() != null && customer.getCustomerActivationDate().length() > 0
				&& customer.getCustomerDeactivationDate() != null && customer.getCustomerDeactivationDate().length() > 0){
			return true;
		}
		else{
			return false;
		}
	}

		public List<Integer> incomeSubscriptionSum(List<Customer> customerList)
		{
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

		public List<Double> costsSum(List<Customer> customerList)
		{
			List<Double> sumOfCosts = new ArrayList<Double>();
			
			for(Customer customer : customerList) 
			{
				costSum = 0;
				
				if(customer.getCustomerContractDetails().getCustomerPlSubscriptions() != null &&
						customer.getCustomerContractDetails().getCustomerPlSubscriptions() > 0)
						
				{
					costSum += customer.getCustomerContractDetails().getCustomerPlSubscriptions() * serverCost;
					costSum += customer.getCustomerContractDetails().getCustomerPlSubscriptions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() != null &&
						customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() > 0)
				{
					costSum += customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() * serverCost;
					costSum += customer.getCustomerContractDetails().getCustomerPlUeSubscriptions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetails().getCustomerRuSubscriptions() != null &&
						customer.getCustomerContractDetails().getCustomerRuSubscriptions() > 0)
				{
					costSum += customer.getCustomerContractDetails().getCustomerRuSubscriptions() * serverCost;
					costSum += customer.getCustomerContractDetails().getCustomerRuSubscriptions() * telematicCardCost;
				}
				sumOfCosts.add(costSum);
			}
			
			return sumOfCosts;
		}
}