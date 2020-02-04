package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindCustomersReturnAsPageServiceImpl implements FindAllReturnAsPageInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(PageRequest pageRequest) {
        log.info("Getting all customer objects from database, returning them as PageRequest");
        return customerRepository.findAll(pageRequest);
    }
}
