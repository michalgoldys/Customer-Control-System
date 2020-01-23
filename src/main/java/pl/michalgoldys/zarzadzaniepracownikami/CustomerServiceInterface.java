package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

public interface CustomerServiceInterface {
	
	int serverCost = 10;
	double telematicCardCost = 2.50;
	
	List<Integer> subscriptionSum(List<Customer> customerList);
	Boolean isActivationCheckboxActive(List<Customer> customerList);
	List<Integer> incomeSubscriptionSum(List<Customer> customerList);
	List<Double> costsSum(List<Customer> customerList);
}
