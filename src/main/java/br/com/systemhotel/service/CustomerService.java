package br.com.systemhotel.service;

import br.com.systemhotel.dto.CustomerDTO;
import br.com.systemhotel.entity.Customer;
import br.com.systemhotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CustomerDTO dto) {
        customerRepository.save(new Customer(dto));
    }
}
