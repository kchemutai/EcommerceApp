package miu.edu.cse.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.order.OrderRequest;
import miu.edu.cse.ecommerce.dto.order.OrderResponse;
import miu.edu.cse.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    private ResponseEntity<OrderResponse> addOrder( @Valid @RequestBody OrderRequest orderRequest) {
        Optional<OrderResponse> orderResponse = orderService.addOrder(orderRequest);
        return ResponseEntity.ok(orderResponse.get());
    }

    @GetMapping("/{customerId}")
    private ResponseEntity<OrderResponse> getOrder(@PathVariable Long customerId) {
        Optional<OrderResponse> orderResponse = orderService.getOrderByCustomerId(customerId);
        if (orderResponse.isPresent()) {
            return ResponseEntity.ok(orderResponse.get());
        }
        return ResponseEntity.notFound().build();
    }
}
