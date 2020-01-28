package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerRepository extends Repository<Customer, Long>, JpaSpecificationExecutor<Customer> {
	
	List<Customer> findAll(Specification<Customer> query);

}
