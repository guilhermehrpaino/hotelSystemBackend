package br.com.systemhotel.dto;

import br.com.systemhotel.entity.Customer;

public record CustomerDTO(Long id, String nome, Integer idade, String cpf, String endereco, String email, String telefone) {

    public CustomerDTO(Customer customer) {
        this(customer.getId(), customer.getNome(), customer.getIdade(), customer.getCpf(),
                customer.getEndereco(), customer.getEmail(), customer.getTelefone());
    }
}
