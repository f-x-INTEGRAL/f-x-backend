package fx.backend.form;

import fx.backend.domain.Order;
import fx.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FormController {
    private final OrderService orderService;
    @PostMapping("/form/save")
    public Map<Order, String> formSave(@ModelAttribute Order order) {
        Map<Order, String> respData = new ConcurrentHashMap<>();

        try {
            orderService.save(order);
        } catch (IllegalArgumentException e) {
            respData.put(order, e.getMessage());
            return respData;
        }
        log.info("order={}", order);
        respData.put(order, "정상적으로 처리 되었습니다.");

        return respData;
    }
}