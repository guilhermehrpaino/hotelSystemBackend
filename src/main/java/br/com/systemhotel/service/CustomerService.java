package br.com.systemhotel.service;

import br.com.systemhotel.dto.CreateCustomerDTO;
import br.com.systemhotel.dto.CustomerResponseDTO;
import br.com.systemhotel.entity.Customer;
import br.com.systemhotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO createCustomer(CreateCustomerDTO dto) {

        if (customerRepository.existsByCpf(dto.cpf())) {
            throw new IllegalStateException("Este CPF já está cadastrado!");
        }
        if (customerRepository.existsByEmail(dto.email())) {
            throw new IllegalStateException("Este email já está cadastrado!");
        }
        Customer customer = new Customer(dto);
        customerRepository.save(customer);
        return new CustomerResponseDTO(customer);

    }


}
