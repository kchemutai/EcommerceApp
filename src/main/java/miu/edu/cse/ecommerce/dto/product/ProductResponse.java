package miu.edu.cse.ecommerce.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String name;
    private BigDecimal price;
}
