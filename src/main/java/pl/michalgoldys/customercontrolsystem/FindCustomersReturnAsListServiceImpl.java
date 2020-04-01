package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class FindCustomersReturnAsListServiceImpl implements FindAllReturnAsCollectionInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> findAll() {
        log.info("Getting all customer objects from database, returning them as ArrayList");
        ArrayList<Customer> listToReturn = new ArrayList<>(customerRepository.findAll());
        return listToReturn;
    }
}
