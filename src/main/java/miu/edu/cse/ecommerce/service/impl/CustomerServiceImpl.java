package miu.edu.cse.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerRequest;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.model.Customer;
import miu.edu.cse.ecommerce.repository.CustomerRepository;
import miu.edu.cse.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerResponse> findCustomerByName(String name) {
        Optional<Customer> customer = customerRepository.findByName(name);
        if (customer.isPresent()) {
            return Optional.of(CustomerResponse.builder()
                    .name(customer.get().getName())
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .build();
        Customer savedCustomer = customerRepository.save(customer);
        return Optional.of(CustomerResponse.builder()
                        .name(savedCustomer.getName())
                .build());
    }

    @Override
    public Optional<CustomerResponse> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return Optional.of(CustomerResponse.builder().name(customer.get().getName()).build());
        }
        return Optional.empty();
    }
}
