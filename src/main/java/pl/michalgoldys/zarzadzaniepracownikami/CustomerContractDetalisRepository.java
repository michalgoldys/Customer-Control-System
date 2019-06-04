package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

public interface CustomerContractDetalisRepository extends Repository<CustomerContractDetalis, Long>{
	
	CustomerContractDetalis save(CustomerContractDetalis customerContractDetalis);
	CustomerContractDetalis findBycustomerContractDetalisId(Long customerContractDetalisId);
}
