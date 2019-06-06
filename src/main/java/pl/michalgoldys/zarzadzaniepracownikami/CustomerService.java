package pl.michalgoldys.zarzadzaniepracownikami;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

		public String getCurrentDate() {
			Date currentDate = new Date();
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
		      
			return (ft.format(currentDate));
		}
		
		public List<Integer> sumingSubscirptionPlUeRu(List<Customer> customerList)
		{
			List<Integer> customerSubstripctionsSum = new ArrayList<Integer>();
			
			for(Customer customer : customerList)
			{
				int subSum = 0;
				
					if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null)
					{
						subSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions();
					}
					if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null)
					{
						subSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions();
					}
					if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null)
					{
						subSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions();
					}
				customerSubstripctionsSum.add(subSum);
			}
			
			return customerSubstripctionsSum;
		}
		
		public Boolean settingActivationCheckbox(List<Customer> customerList)
		{
			boolean isDisabled = false;
			
			for(Customer customer : customerList) {
				
				if(customer.getCustomerActivationDate() != null && customer.getCustomerActivationDate().length() > 0 
						&& customer.getCustomerDeactivationDate() != null && customer.getCustomerDeactivationDate().length() > 0){
					
					isDisabled = true;
				}
			}
			return isDisabled;
		}
		
		public List<Integer> sumOfIncomeBySubscriptions(List<Customer> customerList)
		{
			List<Integer> sumOfIncomeBySubscriptions = new ArrayList<Integer>();
			
			for(Customer customer : customerList)
			{
				int incomeSum = 0;
				
				if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null && customer.getCustomerContractDetalis().getCustomerPlFee() != null
						&& customer.getCustomerContractDetalis().getCustomerPlSubstripctions() > 0 && customer.getCustomerContractDetalis().getCustomerPlFee() > 0)
				{
					incomeSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * customer.getCustomerContractDetalis().getCustomerPlFee();
				}
				if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null && customer.getCustomerContractDetalis().getCustomerPlUeFee() != null
						&& customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() > 0 && customer.getCustomerContractDetalis().getCustomerPlUeFee() > 0)
				{
					incomeSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * customer.getCustomerContractDetalis().getCustomerPlUeFee();
				}
				if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null && customer.getCustomerContractDetalis().getCustomerRuFee() != null
						&& customer.getCustomerContractDetalis().getCustomerRuSubscriptions() > 0 && customer.getCustomerContractDetalis().getCustomerRuFee() > 0)
				{
					incomeSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * customer.getCustomerContractDetalis().getCustomerRuFee();
				}
				sumOfIncomeBySubscriptions.add(incomeSum);
			}
			
			return sumOfIncomeBySubscriptions;
		}
		
		public List<Double> sumOfCosts(List<Customer> customerList)
		{
			List<Double> sumOfCosts = new ArrayList<Double>();
			
			int serverCost = 10;
			double telematicCardCost = 2.50;
			
			for(Customer customer : customerList) 
			{
				double costSum = 0;
				
				if(customer.getCustomerContractDetalis().getCustomerPlSubstripctions() > 0 && 
						customer.getCustomerContractDetalis().getCustomerPlSubstripctions() != null)
				{
					costSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerPlSubstripctions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() > 0 && 
						customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() != null)
				{
					costSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerPlUeSubstripctions() * telematicCardCost;
				}
				if(customer.getCustomerContractDetalis().getCustomerRuSubscriptions() > 0 && 
						customer.getCustomerContractDetalis().getCustomerRuSubscriptions() != null)
				{
					costSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * serverCost;
					costSum += customer.getCustomerContractDetalis().getCustomerRuSubscriptions() * telematicCardCost;
				}
				sumOfCosts.add(costSum);
			}
			
			return sumOfCosts;
		}
}