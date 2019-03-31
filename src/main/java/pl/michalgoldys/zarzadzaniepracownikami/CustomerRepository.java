package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long>{
		
		List<Customer> findBycustomerName(String customerName);
		List<Customer> findBycustomerId(Long customerId);
		List<Customer> save(Customer customer);
		List<Customer> findAll();
}
