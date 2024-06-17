package miu.edu.cse.ecommerce.service;

import miu.edu.cse.ecommerce.dto.order.OrderRequest;
import miu.edu.cse.ecommerce.dto.order.OrderResponse;

import java.util.Optional;

public interface OrderService {
    public Optional<OrderResponse> addOrder(OrderRequest orderRequest);
    public Optional<OrderResponse> getOrderByCustomerId(Long customerId);
}
