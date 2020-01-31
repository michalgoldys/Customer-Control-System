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

        CustomerContractDetails customerContractDetailsToUpdate = customerContractDetailsRepository.findBycustomerContractDetailsId(
                customerContractDetails.getCustomerContractDetailsId());

        customerContractDetailsToUpdate.setCustomerPlFee(customerContractDetails.getCustomerPlFee());
        customerContractDetailsToUpdate.setCustomerPlSubscriptions(customerContractDetails.getCustomerPlSubscriptions());

        customerContractDetailsToUpdate.setCustomerPlUeFee(customerContractDetails.getCustomerPlUeFee());
        customerContractDetailsToUpdate.setCustomerPlUeSubscriptions(customerContractDetails.getCustomerPlUeSubscriptions());

        customerContractDetailsToUpdate.setCustomerRuFee(customerContractDetails.getCustomerRuFee());
        customerContractDetailsToUpdate.setCustomerRuSubscriptions(customerContractDetails.getCustomerRuSubscriptions());

        customerContractDetailsToUpdate.setCustomerEinvoiceAgreement(customerContractDetails.getCustomerEinvoiceAgreement());

        customerContractDetailsRepository.save(customerContractDetailsToUpdate);
    }
}