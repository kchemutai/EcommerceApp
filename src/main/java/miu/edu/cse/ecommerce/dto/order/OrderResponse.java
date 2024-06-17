package miu.edu.cse.ecommerce.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.ecommerce.dto.customer.CustomerResponse;
import miu.edu.cse.ecommerce.dto.product.ProductResponse;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponse {
    private CustomerResponse customerResponse;
    private LocalDate orderDate;
    private List<ProductResponse> productResponses;
}
