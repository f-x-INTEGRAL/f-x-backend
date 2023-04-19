package fx.backend;

import fx.backend.repository.OrderRepository;
import fx.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("")
                .allowedHeaders("https://nabom.live", "https://f-x-frontend.vercel.app")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

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
