package pl.michalgoldys.customercontrolsystem;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CustomerSpecificationExecutorRepository extends Repository<Customer, Long>, JpaSpecificationExecutor<Customer> {
	
	List<Customer> findAll(Specification<Customer> query);

}
