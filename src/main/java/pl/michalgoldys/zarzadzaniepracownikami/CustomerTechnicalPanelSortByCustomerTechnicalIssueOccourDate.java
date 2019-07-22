package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.Comparator;

public class CustomerTechnicalPanelSortByCustomerTechnicalIssueOccourDate implements Comparator<CustomerTechnicalPanel> {

	@Override
	public int compare(CustomerTechnicalPanel o1, CustomerTechnicalPanel o2) {
		return o1.getCustomerTechnicalIssueOccourDate().compareTo(o2.getCustomerTechnicalIssueOccourDate());
	}
}