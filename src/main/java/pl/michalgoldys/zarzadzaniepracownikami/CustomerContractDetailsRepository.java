package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

public interface CustomerContractDetailsRepository extends Repository<CustomerContractDetails, Long>{
	
	CustomerContractDetails save(CustomerContractDetails customerContractDetails);
	CustomerContractDetails findBycustomerContractDetailsId(Long customerContractDetailsId);
}
