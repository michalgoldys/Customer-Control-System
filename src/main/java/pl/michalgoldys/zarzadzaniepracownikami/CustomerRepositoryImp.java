package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryImp extends JpaRepository<Customer, Long> {
	
	Customer findBycustomerContractPdfId(String customerContractPdfId); 

}
