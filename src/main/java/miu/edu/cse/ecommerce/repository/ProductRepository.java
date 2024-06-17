package miu.edu.cse.ecommerce.repository;

import miu.edu.cse.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
