package br.com.systemhotel.controller;


import br.com.systemhotel.dto.CreateEmployeeDTO;
import br.com.systemhotel.dto.EmployeeResponseDTO;
import br.com.systemhotel.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AdminEmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public AdminEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/funcionarios")
    public EmployeeResponseDTO create (@Valid @RequestBody CreateEmployeeDTO dto) {
        return employeeService.createEmployee(dto);
    }
}
