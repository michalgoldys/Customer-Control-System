package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.LinkedList;

import org.springframework.data.repository.Repository;

public interface CompanyReprosytory extends Repository<Company, Long> {

	LinkedList<Company> findyBycompanyID(Long companyAdressId);
	
}
