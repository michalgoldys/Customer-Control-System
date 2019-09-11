package pl.michalgoldys.zarzadzaniepracownikami;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface CustomerServiceImplementation {
	
	default String getCurrentDate() {
		Date currentDate = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
	      
		return (ft.format(currentDate));
	}
	
	List<Integer> sumingSubscirptionPlUeRu(List<Customer> customerList);
	Boolean settingActivationCheckbox(List<Customer> customerList);
	List<Integer> sumOfIncomeBySubscriptions(List<Customer> customerList);
	List<Double> sumOfCosts(List<Customer> customerList);
}
