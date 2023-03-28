package fx.backend.repository;

import fx.backend.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryOrderRepository implements OrderRepository {

    public static Map<Long, Order> orderMap = new ConcurrentHashMap<>();
    public static AtomicLong sequence = new AtomicLong(0);

    @Override
    public Order save(Order order) {
        order.setID(sequence.incrementAndGet());
        orderMap.put(order.getID(), order);

        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    @Override
    public Optional<Order> findByPhoneNumber(Long phoneNumber) {
        return orderMap.values().stream()
                .filter(order -> order.getPhoneNumber().equals(phoneNumber))
                .findAny();
    }

    @Override
    public List<Order> findAlL() {
        return new ArrayList<>(orderMap.values());
    }
}
