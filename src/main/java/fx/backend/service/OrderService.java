package fx.backend.service;

import fx.backend.domain.OrderStatus;
import fx.backend.domain.Orders;
import fx.backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:application.properties")
public class OrderService {
    @Value("${admin.password}")
    private String password;

    private final OrderRepository orderRepository;

    public void save(Orders orders) {
        validateDuplicatePhoneNumber(orders);
        orderRepository.save(orders);
    }

    private void validateDuplicatePhoneNumber(Orders orders) {
        orderRepository.findByPhoneNumber(orders.getPhoneNumber()).ifPresent(a -> {
            throw new IllegalArgumentException("이미 존재하는 전화번호 입니다.");
        });
    }

    public Optional<Orders> findByPhoneNumber(String phoneNumber) {
        return orderRepository.findByPhoneNumber(phoneNumber);
    }

    public Orders updateOrderStatus(Long orderId, OrderStatus status) {
        Orders orders = findById(orderId);

        orders.setStatus(status);
        orderRepository.save(orders);

        return orders;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    public Orders findById(Long Id){
        Optional<Orders> orders = orderRepository.findById(Id);

        if (orders.isEmpty())
            throw new NoSuchElementException(Id + "번 아이템은 존재하지 않습니다.");

        return orders.get();
    }

    public boolean login(String userPassword) {
        log.info("password={}", password);
        log.info("userPassword={}", userPassword);
        return userPassword.equals(password);
    }
}
