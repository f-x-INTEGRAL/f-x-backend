package fx.backend.form;

import fx.backend.domain.Order;
import fx.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FormController {
    private final OrderService orderService;

    @PostMapping("/form/save")
    public String formSave(@RequestBody Order order) {
        orderService.save(order);
        log.info("order={}", order);

        return "ok";
    }

}
