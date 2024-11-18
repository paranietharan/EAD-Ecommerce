package com.teamz.customer.controller;

import DTO.CustomerDTO;
import com.teamz.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("id")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerByID(id));
    }
}
