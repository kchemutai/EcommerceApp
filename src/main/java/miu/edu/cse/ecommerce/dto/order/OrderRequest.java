package miu.edu.cse.ecommerce.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerRequest;
import miu.edu.cse.ecommerce.dto.product.ProductRequest;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    @NotEmpty(message = "Customer missing")
    private CustomerRequest customer;

    @NotEmpty(message = "Products cannot be null or empty")
    private List<ProductRequest> productRequests;
}
