package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
		
		List<Customer> findBycustomerName(String customerName);
		List<Customer> findBycustomerId(Long customerId);
		List<Customer> findAll();
		List<Customer> findBycustomerContractPdfId(String customerContractPdfId);
}
