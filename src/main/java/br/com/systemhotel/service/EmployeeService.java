package br.com.systemhotel.service;

import br.com.systemhotel.dto.CreateCustomerDTO;
import br.com.systemhotel.dto.CreateEmployeeDTO;
import br.com.systemhotel.dto.EmployeeResponseDTO;
import br.com.systemhotel.entity.Employee;
import br.com.systemhotel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository funcionarioRepository;

    @Autowired
    public EmployeeService(EmployeeRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public EmployeeResponseDTO createEmployee (CreateEmployeeDTO dto) {

        if (funcionarioRepository.existsByCpf(dto.cpf())) {
            throw new IllegalStateException("Este CPF já está cadastrado!");
        }
        if (funcionarioRepository.existsByEmail(dto.email())) {
            throw new IllegalStateException("Este email já está cadastrado!");
        }
        Employee employee = new Employee(dto);
        funcionarioRepository.save(employee);
        return new EmployeeResponseDTO(employee);


    }
}
