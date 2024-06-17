package miu.edu.cse.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull(message = "Customer missing")
    private Customer customer;

    @Column(nullable = false)
    @NotEmpty(message = "Date missing")
    private LocalDate orderDate;

    @NotEmpty(message = "Products cannot be null or empty")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Product> products;

    public Order(Customer customer, LocalDate orderDate, List<Product> products) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
