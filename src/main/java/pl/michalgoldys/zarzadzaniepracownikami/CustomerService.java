package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceImplementation, TimeInterface {

		boolean isDisabled;
		int sum;
		double costSum;

		@Override
	public String getCurrentDateAsString() {
		return TimeInterface.super.getCurrentDateAsString();
	}

		@Override
		public List<Integer> subscritionSum(List<Customer> customerList)
		{
			List<Integer> customerSubstripctionsSum = new ArrayList<Integer>();
			/*
			int sum = 0;
			
			sum += customerList.stream()
					.mapToInt(c -> c.getCustomerContractDetalis().getCustomerPlSubstripctions())
					.sum();
			
			sum += customerList.stream()
					.mapToInt(c -> c.getCustomerContractDetalis().getCustomerPlUeSubstripctions())
					.sum();
			
			sum += customerList.stream()
					.mapToInt(c -> c.getCustomerContractDetalis().getCustomerRuSubscriptions())
					.sum();
			
			*/
			for(Customer customer : customerList)
			{
				sum = 0;
				
					if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null)
					{
						sum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions();
					}
					if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null)
					{
						sum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions();
					}
					if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null)
					{
						sum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions();
					}
				customerSubstripctionsSum.add(sum);
			}
			
			customerSubstripctionsSum.add(sum);
			return customerSubstripctionsSum;
		}
		
		@Override
		public Boolean isActivationCheckboxActive(List<Customer> customerList)
		{
			isDisabled = false;
			
			customerList.forEach(c -> {
				if(c.getCustomerActivationDate() != null && c.getCustomerActivationDate().length() > 0 
						&& c.getCustomerDeactivationDate() != null && c.getCustomerDeactivationDate().length() > 0){
					
					isDisabled = true;
				}
			});
			/*
			for(Customer customer : customerList) {
				
				if(customer.getCustomerActivationDate() != null && customer.getCustomerActivationDate().length() > 0 
						&& customer.getCustomerDeactivationDate() != null && customer.getCustomerDeactivationDate().length() > 0){
					
					isDisabled = true;
				}
			}
			*/
			return isDisabled;
		}
		
		@Override
		public List<Integer> incomeSubscriptionSum(List<Customer> customerList)
		{
			List<Integer> sumOfIncomeBySubscriptions = new ArrayList<Integer>();
			
			 sum = customerList.stream()
			.filter(c -> c.getCustomerContractDetalis().getCustomerPlSubstripctions() > 0 && c.getCustomerContractDetalis().getCustomerPlFee() > 0 &&
					c.getCustomerContractDetalis().getCustomerPlUeSubstripctions() > 0 && c.getCustomerContractDetalis().getCustomerPlUeFee() > 0 &&
					c.getCustomerContractDetalis().getCustomerRuSubscriptions() > 0 && c.getCustomerContractDetalis().getCustomerRuFee() > 0 &&
					c.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null && c.getCustomerContractDetalis().getCustomerPlFee() != null &&
					c.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null && c.getCustomerContractDetalis().getCustomerPlUeFee() != null &&
					c.getCustomerContractDetalis().getCustomerRuSubscriptions() != null && c.getCustomerContractDetalis().getCustomerRuFee() != null)
			.mapToInt(c -> {
				return c.getCustomerContractDetalis().getCustomerPlFee() * c.getCustomerContractDetalis().getCustomerPlSubstripctions() *
						c.getCustomerContractDetalis().getCustomerPlUeFee() * c.getCustomerContractDetalis().getCustomerPlUeSubstripctions() *
						c.getCustomerContractDetalis().getCustomerRuFee() * c.getCustomerContractDetalis().getCustomerRuSubscriptions();
			})
			.sum();
			
			 System.out.print(sum);
			
			for(Customer customer : customerList)
			{
				sum = 0;
				
				if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null && customer.getCustomerContractDetalis().getCustomerPlFee() != null
						&& customer.getCustomerContractDetalis().getCustomerPlSubstripctions() > 0 && customer.getCustomerContractDetalis().getCustomerPlFee() > 0)
				{
					sum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * customer.getCustomerContractDetalis().getCustomerPlFee();
				}
				if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null && customer.getCustomerContractDetalis().getCustomerPlUeFee() != null
						&& customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() > 0 && customer.getCustomerContractDetalis().getCustomerPlUeFee() > 0)
				{
					sum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * customer.getCustomerContractDetalis().getCustomerPlUeFee();
				}
				if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null && customer.getCustomerContractDetalis().getCustomerRuFee() != null
						&& customer.getCustomerContractDetalis().getCustomerRuSubscriptions() > 0 && customer.getCustomerContractDetalis().getCustomerRuFee() > 0)
				{
					sum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * customer.getCustomerContractDetalis().getCustomerRuFee();
				}
				sumOfIncomeBySubscriptions.add(sum);
			}
			
			return sumOfIncomeBySubscriptions;
		}
		
		@Override
		public List<Double> costsSum(List<Customer> customerList)
		{
			List<Double> sumOfCosts = new ArrayList<Double>();
			
			for(Customer customer : customerList) 
			{
				costSum = 0;
				
				if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null &&
						customer.getCustomerContractDetalis().getCustomerPlSubstripctions() > 0)
						
				{
					costSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null &&
						customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() > 0)
				{
					costSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null &&
						customer.getCustomerContractDetalis().getCustomerRuSubscriptions() > 0)
				{
					costSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * telematicCardCost;
				}
				sumOfCosts.add(costSum);
			}
			
			return sumOfCosts;
		}
}