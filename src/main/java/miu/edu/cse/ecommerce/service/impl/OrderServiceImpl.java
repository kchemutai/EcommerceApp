package miu.edu.cse.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerRequest;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.dto.order.OrderRequest;
import miu.edu.cse.ecommerce.dto.order.OrderResponse;
import miu.edu.cse.ecommerce.dto.product.ProductResponse;
import miu.edu.cse.ecommerce.model.Customer;
import miu.edu.cse.ecommerce.model.Order;
import miu.edu.cse.ecommerce.model.Product;
import miu.edu.cse.ecommerce.repository.OrderRepository;
import miu.edu.cse.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Optional<OrderResponse> addOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderDate(LocalDate.now())
                .customer(Customer.builder().name(orderRequest.getCustomer().getName()).build())
                .products(orderRequest.getProductRequests().stream().map(
                        productRequest -> {
                            return Product.builder()
                                    .name(productRequest.getName())
                                    .price(productRequest.getPrice())
                                    .build();
                        }
                ).toList())
                .build();
        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = OrderResponse.builder()
                .customerResponse(CustomerResponse.builder().name(savedOrder.getCustomer().getName()).build())
                .orderDate(savedOrder.getOrderDate())
                .productResponses(savedOrder.getProducts().stream().map(
                        product -> {
                            return ProductResponse.builder()
                                   .name(product.getName())
                                   .price(product.getPrice())
                                   .build();
                        }
                )
                        .toList())
                .build();
        return Optional.of(orderResponse);
    }

    @Override
    public Optional<OrderResponse> getOrderByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findAll();
        Optional<Order> foundOrder = orderRepository.findAll().stream().filter(order -> order.getCustomer().getId().equals(customerId)).findFirst();
        if (foundOrder.isPresent()) {
            Order order = foundOrder.get();
            return Optional.of(OrderResponse.builder()
                            .customerResponse(CustomerResponse.builder().name(order.getCustomer().getName()).build())
                            .productResponses(
                                    order.getProducts().stream().map(
                                            product -> {
                                                return ProductResponse.builder().name(product.getName()).price(product.getPrice()).build();
                                            }
                                    ).toList()
                            )
                    .build());
        }
        return Optional.empty();
    }
}
