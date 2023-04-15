package fx.backend;

import fx.backend.repository.OrderRepository;
import fx.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final OrderRepository orderRepository;

    @Autowired
    public SpringConfig(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public OrderService orderService() {
        return new OrderService(orderRepository);
    }

}
