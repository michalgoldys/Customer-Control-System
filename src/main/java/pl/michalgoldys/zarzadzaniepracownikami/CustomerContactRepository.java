package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerContactRepository extends Repository<CustomerContact, Long> {
	
	List<CustomerContact> findBycustomerContactId(Long customerContactId);
	List<CustomerContact> save(CustomerContact customerContact);
}
