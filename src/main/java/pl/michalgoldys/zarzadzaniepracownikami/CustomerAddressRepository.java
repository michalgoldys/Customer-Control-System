package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerAddressRepository extends Repository<CustomerAddress, Long> {
	
	List<CustomerAddress> findBycustomerAddressId(Long customerAdressId);
	List<CustomerAddress> save(CustomerAddress customerAddress);
	
}
