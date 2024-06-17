package miu.edu.cse.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.ecommerce.dto.product.ProductRequest;
import miu.edu.cse.ecommerce.dto.product.ProductResponse;
import miu.edu.cse.ecommerce.model.Product;
import miu.edu.cse.ecommerce.repository.ProductRepository;
import miu.edu.cse.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<List<ProductResponse>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(!products.isEmpty()) {

            List<ProductResponse> productResponses = products.stream().map(product -> {
                return ProductResponse.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build();
            }).toList();
            return Optional.of(productResponses);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponse> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            Product foundProduct = product.get();
            return Optional.of(ProductResponse.builder()
                    .name(foundProduct.getName())
                    .price(foundProduct.getPrice())
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponse> addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();
        Product savedProduct = productRepository.save(product);
        return Optional.of(ProductResponse.builder()
                        .name(savedProduct.getName())
                        .price(savedProduct.getPrice())
                .build());
    }
}
