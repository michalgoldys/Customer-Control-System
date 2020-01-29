package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

public interface CustomerRepositoryImp extends Repository<Customer, Long> {
	
	Customer findBycustomerContractPdfId(String customerContractPdfId);
}
