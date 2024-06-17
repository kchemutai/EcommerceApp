package miu.edu.cse.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.product.ProductRequest;
import miu.edu.cse.ecommerce.dto.product.ProductResponse;
import miu.edu.cse.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct( @Valid @RequestBody ProductRequest productRequest) {
        Optional<ProductResponse> productResponse = productService.addProduct(productRequest);
        return ResponseEntity.ok(productResponse.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        Optional<ProductResponse> productResponse = productService.getProductById(id);
        if (productResponse.isPresent()) {
            return ResponseEntity.ok(productResponse.get());
        }
        return ResponseEntity.notFound().build();
    }

}
