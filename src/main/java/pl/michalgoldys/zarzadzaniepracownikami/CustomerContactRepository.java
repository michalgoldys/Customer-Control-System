package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CustomerContactRepository extends Repository<CustomerContact, Long> {
	
	List<CustomerContact> findBycustomerContactId(Long customerContactId);
	List<CustomerContact> save(CustomerContact customerContact);
	CustomerContact findBycustomerId(Long customerId);	
}
