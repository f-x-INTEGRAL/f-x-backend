package fx.backend.repository;

import fx.backend.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemoryOrderRepositoryTest {

    private final OrderRepository orderRepository = new MemoryOrderRepository();

    @AfterEach
    void clearRepository() {
        orderRepository.clearAll();
    }

    @Test
    void deleteOrder() {
        Order order1 = new Order("테스트1", 1, "01033504202", "테스트예금주");
        orderRepository.save(order1);

        Long testLong = 1L;
        orderRepository.deleteById(testLong);

        assertThat(orderRepository.findAlL()).isEmpty();
    }

    @Test
    void editOrder(){
        Order order1 = new Order("테스트1", 1, "01033504202", "테스트예금주");
        orderRepository.save(order1);

        Order order2 = new Order("테스트2", 1, "01033504202", "테스트예금주");

        orderRepository.editOrder(1L, order2);
        assertThat(orderRepository.findById(1L)).isEqualTo(Optional.of(order2));
    }
}
