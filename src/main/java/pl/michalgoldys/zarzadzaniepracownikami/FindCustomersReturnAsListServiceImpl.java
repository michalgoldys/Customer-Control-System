package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class FindCustomersReturnAsListServiceImpl implements FindAllReturnAsCollectionInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> findAll() {
        log.info("Getting all customer object from database, return as list.. ");
        return customerRepository.findAll();
    }
}
