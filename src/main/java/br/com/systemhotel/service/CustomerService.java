package br.com.systemhotel.service;

import br.com.systemhotel.entity.Customer;
import br.com.systemhotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String nome, Integer idade, String telefone, String email, String endereco, String cpf) {

        Customer customer = new Customer(nome, idade, cpf, telefone, email, endereco);

        return customerRepository.save(customer);
    }
}
