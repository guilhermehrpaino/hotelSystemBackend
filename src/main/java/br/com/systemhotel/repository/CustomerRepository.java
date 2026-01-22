package br.com.systemhotel.repository;

import br.com.systemhotel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    boolean existsByCpf(String cpf);
}
