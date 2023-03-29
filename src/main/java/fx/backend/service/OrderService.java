package fx.backend.service;

import fx.backend.domain.Order;
import fx.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        validateDuplicatePhoneNumber(order);
        orderRepository.save(order);
    }

    private void validateDuplicatePhoneNumber(Order order) {
        orderRepository.findByPhoneNumber(order.getPhoneNumber()).ifPresent(a -> {
            throw new IllegalArgumentException("이미 존재하는 전화번호 입니다.");
        });
    }

    public Optional<Order> findByPhoneNumber(Long phoneNumber) {
        return orderRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Order> findAll() {
        return orderRepository.findAlL();
    }

    public Optional<Order> findById(Long Id){
        Optional<Order> order = orderRepository.findById(Id);
                order.ifPresent(a -> {
            throw new IllegalArgumentException("유효하지 않은 ID 입니다");
        });

        return order;
    }
}
