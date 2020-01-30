package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerContractDatabaseUpdateService implements DatabaseGenericUpdate<CustomerContractDetails> {

    @Autowired
    CustomerContractDetailsRepository customerContractDetailsRepository;

    @Override
    public void update(CustomerContractDetails customerContractDetails) {

        log.info("About to persist object: " + customerContractDetails.toString());

        customerContractDetailsRepository.save(customerContractDetails);
    }
}
