package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

public interface CustomerServiceImplementation {
	
	int serverCost = 10;
	double telematicCardCost = 2.50;
	
	List<Integer> subscritionSum(List<Customer> customerList);
	Boolean isActivationCheckboxActive(List<Customer> customerList);
	List<Integer> incomeSubscriptionSum(List<Customer> customerList);
	List<Double> costsSum(List<Customer> customerList);
}
