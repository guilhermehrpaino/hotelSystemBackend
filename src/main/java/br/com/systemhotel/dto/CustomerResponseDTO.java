package br.com.systemhotel.dto;

import br.com.systemhotel.entity.Customer;

public record CustomerResponseDTO(
        Long id,
        String nome,
        Integer idade,
        String cpf,
        String telefone,
        String email,
        String endereco
) {
    public CustomerResponseDTO (Customer customer){
        this(
                customer.getId(),
                customer.getNome(),
                customer.getIdade(),
                customer.getCpf(),
                customer.getTelefone(),
                customer.getEmail(),
                customer.getEndereco()
        );
    }
}
