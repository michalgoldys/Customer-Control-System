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
		
		public Boolean isActivationCheckboxDisabled(List<Customer> customerList)
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
}