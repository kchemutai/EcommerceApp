package miu.edu.cse.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerRequest;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Optional<CustomerResponse> CustomerResponse = customerService.addCustomer(customerRequest);
        return ResponseEntity.ok(CustomerResponse.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
        Optional<CustomerResponse> CustomerResponse = customerService.getCustomerById(id);
        if (CustomerResponse.isPresent()) {
            return ResponseEntity.ok(CustomerResponse.get());
        }
        return ResponseEntity.notFound().build();
    }

}
