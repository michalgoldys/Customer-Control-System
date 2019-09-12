package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DatabaseOperationInterface {
	
	@Transactional
	List<Customer> findAllCustomers();
	
	@Transactional
	Page<Customer> findAllCustomers(PageRequest pageRequest);
	
	@Transactional
	List<Customer> listFindByCustomerContractPdfId(String customerSelectionId);	
	
	@Transactional
	public Customer customerFindByCustomerContractPdfId(String customerSelectionId);

}
