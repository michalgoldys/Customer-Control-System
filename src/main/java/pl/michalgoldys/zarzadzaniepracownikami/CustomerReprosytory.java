package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CustomerReprosytory extends Repository<Customer, Long>{
		
		List<Customer> findByCustomerName(String customerName);
		List<Customer> findByCustomerId(Long customerId);
}
