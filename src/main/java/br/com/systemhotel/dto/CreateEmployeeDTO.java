package br.com.systemhotel.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateEmployeeDTO(

    @NotBlank(message = "nome é obrigatório")
    @Pattern(regexp = "[A-Za-zÀ-ÿ ]+")
    String nome,

    @Email(message = "Email é obrigatório")
    String email,


    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter no mínimo 11 dígitos")
    String cpf,

    @NotBlank(message = "Salário é obrigatório")
    String salario,

    @NotBlank(message = "O cargo é obrigatório")
    String cargo,

    String telefone,
    Integer idade,
    String endereco


){}
