package miu.edu.cse.ecommerce.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import miu.edu.cse.ecommerce.dto.product.ProductRequest;
import miu.edu.cse.ecommerce.dto.product.ProductResponse;
import miu.edu.cse.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Optional<List<ProductResponse>> getAllProducts();
    public Optional<ProductResponse> getProductById(Long id);
    public Optional<ProductResponse> addProduct(ProductRequest productRequest);
}
