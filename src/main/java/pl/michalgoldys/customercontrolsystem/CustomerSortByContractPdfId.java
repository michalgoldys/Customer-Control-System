package pl.michalgoldys.customercontrolsystem;

import java.util.Comparator;

public class CustomerSortByContractPdfId implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getCustomerContractPdfId().compareTo(o2.getCustomerContractPdfId());
	}

}
