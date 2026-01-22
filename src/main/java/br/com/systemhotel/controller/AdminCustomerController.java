package br.com.systemhotel.controller;


import br.com.systemhotel.dto.CreateCustomerDTO;
import br.com.systemhotel.dto.CustomerResponseDTO;
import br.com.systemhotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminCustomerController {


    private final CustomerService service;

    @Autowired
    public AdminCustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/clientes")
    public CustomerResponseDTO create (@RequestBody CreateCustomerDTO dto) {
        return service.createCustomer(dto);
    }


}
