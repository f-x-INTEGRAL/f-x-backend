package fx.backend.repository;

import fx.backend.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Orders save(Orders orders);
    Optional<Orders> findById(Long orderId);
    Optional<Orders> findByPhoneNumber(String phoneNumber);
    List<Orders> findAll();
   void deleteById(Long orderId);
   Long sumConformedOrdersQuantity();
}
