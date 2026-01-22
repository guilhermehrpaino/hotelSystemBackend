package br.com.systemhotel.dto;

public record CreateCustomerDTO(
    String nome,
    Integer idade,
    String cpf,
    String telefone,
    String email,
    String endereco
){}
