package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDatabaseService implements DatabaseOperationInterface{

		@Autowired
		CustomerRepository customerRepository;

		@Autowired
		CustomerRepositoryImp customerRepositoryImp;

		@Override
		public List<Customer> findAllCustomers()
		{
			return(customerRepository.findAll());
		}
		
		@Override
		public Page<Customer> findAllCustomers(PageRequest pageRequest)
		{
			return(customerRepository.findAll(pageRequest));
		}

		@Override
		public List<Customer> listFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepository.findBycustomerContractPdfId(customerSelectionId));
		}

		@Override
		public Customer customerFindByCustomerContractPdfId(String customerSelectionId)
		{
			return(customerRepositoryImp.findBycustomerContractPdfId(customerSelectionId));
		}
}