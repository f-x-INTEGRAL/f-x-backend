package fx.backend.repository;

import fx.backend.domain.OrderStatus;
import fx.backend.domain.Orders;
import fx.backend.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringDataJpaRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    void updateOrder() {
        orderService.updateOrderStatus(3L, OrderStatus.CONFORMED);

        Orders orderById = orderService.findById(3L);

        Assertions.assertThat(orderById.getStatus()).isEqualTo(OrderStatus.CONFORMED);
    }
}