package miu.edu.cse.ecommerce.service;

import miu.edu.cse.ecommerce.dto.customer.CustomerRequest;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.model.Customer;

import java.util.Optional;

public interface CustomerService {
    public Optional<CustomerResponse> findCustomerByName(String name);
    public Optional<CustomerResponse> addCustomer(CustomerRequest customerRequest);
    public Optional<CustomerResponse> getCustomerById(Long id);
}
