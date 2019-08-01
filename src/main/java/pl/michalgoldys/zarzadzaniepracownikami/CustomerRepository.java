package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
		
		List<Customer> findBycustomerName(String customerName);
		List<Customer> findBycustomerId(Long customerId);
		Page<Customer> findAll(Pageable pageable);
		List<Customer> findAll();
		List<Customer> findBycustomerContractPdfId(String customerContractPdfId);
}