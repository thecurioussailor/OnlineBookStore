package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.Customer;
import com.vecv.obsapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId){

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if(optionalCustomer.isPresent()){
            return ResponseEntity.ok(optionalCustomer.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

        //save the customer
        Customer createCustomer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomer);

    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            existingCustomer.setAddressLine1(updatedCustomer.getAddressLine1());
            existingCustomer.setAddressLine2(updatedCustomer.getAddressLine2());
            existingCustomer.setCity(updatedCustomer.getCity());
            existingCustomer.setState(updatedCustomer.getState());
            existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
            existingCustomer.setCountry(updatedCustomer.getCountry());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());


            Customer updatedCustomerObj = customerRepository.save(existingCustomer);
            return ResponseEntity.ok(updatedCustomerObj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
