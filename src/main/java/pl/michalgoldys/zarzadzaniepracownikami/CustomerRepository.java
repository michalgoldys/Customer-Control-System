package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long>, JpaSpecificationExecutor<Customer> {
	
	List<Customer> findAll(Specification<Customer> query);
	
	/*
	@Query("SELECT U FROM CUSTOMER WHERE U.query = ?1")
	List<Customer> findAll(String query);
	*/
}
