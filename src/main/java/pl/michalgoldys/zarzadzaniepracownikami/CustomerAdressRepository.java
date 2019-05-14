package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CustomerAdressRepository extends Repository<CustomerAdress, Long> {
	
	List<CustomerAdress> findBycustomerAdressId(Long customerAdressId);
	List<CustomerAdress> save(CustomerAdress customerAdress);
	CustomerAdress findBycustomerId(Long customerId);
	
}
