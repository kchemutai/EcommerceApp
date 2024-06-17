package miu.edu.cse.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.model.Customer;
import miu.edu.cse.ecommerce.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getCustomer() throws Exception {
        Customer customer = new Customer("Silas");
        CustomerResponse customerResponse = CustomerResponse.builder().name(customer.getName()).build();
        Mockito.when(customerService.getCustomerById(Mockito.anyLong())).thenReturn(Optional.of(customerResponse));

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(customer.getName()));
    }
}