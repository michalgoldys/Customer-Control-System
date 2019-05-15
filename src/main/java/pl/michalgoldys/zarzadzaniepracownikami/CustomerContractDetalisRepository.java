package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CustomerContractDetalisRepository extends Repository<CustomerContractDetalis, Long>{
	
	List<CustomerContractDetalis> save(CustomerContractDetalis customerContractDetalis);
}
