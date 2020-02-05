package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindByCustomerIdReturnAsTypeServiceImpl implements FindByStringReturnAsTypeInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findBy(String string) {
        log.info("Getting customer object by string .. ");
        return customerRepository.findBycustomerContractPdfId(string);
    }
}
