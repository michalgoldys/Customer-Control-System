package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpecificationSearchImplementation {

	public static Specification<Customer> textInAllColumns(String text) {

	        return new Specification<Customer>() {

				@Override
	            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> cq, CriteriaBuilder builder) {
	                return builder.or(root.getModel().getDeclaredSingularAttributes()
	                		.stream()
	                		.filter(a-> {
	                    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
	                        return true;
	                    }
	                    else {
	                        return false;
	                }})
	                		.map(a -> builder.like(root.get(a.getName()), text)
	                    )
	                		.toArray(Predicate[]::new)
	                );
	            }
	        };
	    }
}