package miu.edu.cse.ecommerce.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "Product name cannot be null or empty")
    private String name;

    @NotNull(message = "Product Price cannot be null or empty")
    @Min(1)
    private BigDecimal price;
}
