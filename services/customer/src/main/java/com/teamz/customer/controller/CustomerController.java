package com.teamz.customer.controller;

import com.teamz.customer.DTO.CustomerDTO;
import com.teamz.customer.DTO.UpdateCustomerDetailsDTO;
import com.teamz.customer.entity.Address;
import com.teamz.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerByID(id));
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<CustomerDTO> addAddressForACustomer(@PathVariable("id") Long id, @RequestBody Address address) {
        return ResponseEntity.ok(customerService.addAddressForACustomer(id, address));
    }


    @PatchMapping("/customerDetails/{id}")
    public ResponseEntity<String> updateCustomerDetails(@PathVariable("id") Long id, @RequestBody UpdateCustomerDetailsDTO updateCustomerDetailsDTO){
        customerService.updateCustomerDetails(id,updateCustomerDetailsDTO);
        return ResponseEntity.ok("Customer details Updated Successfully");
    }

    @PatchMapping("/customerAddress/{id}")
    public ResponseEntity<String> updateCustomerAddress(@PathVariable("id") Long id, @RequestBody Address address){
        customerService.updateCustomerAddress(id,address);
        return ResponseEntity.ok("Customer Address Updated Successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> DeleteCustomerId(@PathVariable("id") Long id){
        customerService.DeleteCustomerId(id);
        return ResponseEntity.ok("Customer Deleted Successfully");
    }
}
