package miu.edu.cse.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Product name cannot be null or empty")
    private String name;

    @NotNull(message = "Price must not be null or empty")
    private BigDecimal price;

    public Product(String name, BigDecimal price, Order order) {
        this.name = name;
        this.price = price;
    }

}
