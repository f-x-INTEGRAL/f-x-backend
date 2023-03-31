package fx.backend.repository;

import fx.backend.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    Optional<Order> findByPhoneNumber(String phoneNumber);
    List<Order> findAlL();
}
