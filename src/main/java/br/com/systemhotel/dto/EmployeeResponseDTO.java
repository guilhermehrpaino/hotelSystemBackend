package br.com.systemhotel.dto;

import br.com.systemhotel.entity.Employee;

public record EmployeeResponseDTO(
        Long id,
        String nome,
        Integer idade,
        String email,
        String endereco,
        String telefone,
        String cpf,
        String salario,
        String cargo
) {
    public EmployeeResponseDTO (Employee employee){
      this(
                employee.getId(),
                employee.getNome(),
                employee.getIdade(),
                employee.getEmail(),
                employee.getEndereco(),
                employee.getTelefone(),
                employee.getCpf(),
                employee.getSalario(),
                employee.getCargo()
      );
    }
}
