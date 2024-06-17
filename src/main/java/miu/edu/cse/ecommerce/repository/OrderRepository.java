package miu.edu.cse.ecommerce.repository;

import miu.edu.cse.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
