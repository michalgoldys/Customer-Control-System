package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerRepository extends Repository<Customer, Long> {

	Page<Customer> findAll(Pageable pageable);
	List<Customer> findAll();

	Customer save(Customer customer);
	Customer findBycustomerContractPdfId(String customerContractPdfId);
}