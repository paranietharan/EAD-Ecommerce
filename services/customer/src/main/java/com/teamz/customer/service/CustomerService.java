package com.teamz.customer.service;

import DTO.CustomerDTO;
import com.teamz.customer.entity.User;
import com.teamz.customer.exceptions.CustomerNotFoundException;
import com.teamz.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO getCustomerByID(Long id) {
            User user=customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));


        return CustomerDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress() != null ? user.getAddress() : null)
                .phoneNo(user.getPhoneNo())
                .build();
    }
}
