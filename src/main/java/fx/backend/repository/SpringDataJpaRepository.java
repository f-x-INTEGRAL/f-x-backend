package fx.backend.repository;

import fx.backend.domain.OrderStatus;
import fx.backend.domain.Orders;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Primary
public interface SpringDataJpaRepository extends JpaRepository<Orders, Long>, OrderRepository{
    @Query("SELECT SUM(o.quantity) FROM Orders o WHERE o.status = 1")
    Long sumConformedOrdersQuantity();
}
