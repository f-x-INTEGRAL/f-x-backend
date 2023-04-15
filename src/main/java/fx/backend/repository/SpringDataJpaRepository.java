package fx.backend.repository;

import fx.backend.domain.Orders;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface SpringDataJpaRepository extends JpaRepository<Orders, Long>, OrderRepository{
}
