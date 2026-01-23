package br.com.systemhotel.repository;

import br.com.systemhotel.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}
