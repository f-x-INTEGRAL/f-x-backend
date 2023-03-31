package fx.backend.form;

import fx.backend.domain.Order;
import fx.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FormController {
    private final OrderService orderService;

    /**
     * Body 의 메세지를 받아 저장하고, 그 과정에서 같은 유저가 있는지 검증한다.
     *
     * @param order
     * @return HttpStatus 201, 422
     */

    @PostMapping("/form/save")
    public ResponseEntity<?> fromSave(@ModelAttribute Order order) {
        log.info("order={}", order);
        try {
            orderService.save(order);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * GET 요청으로 orderId를 받아, 해당 orderId에 맞는 order 를 반환 한다
     *
     * @param orderId
     * @return Order
     */

    @GetMapping("/form/{orderId}")
    public ResponseEntity<?> findOrderById(@PathVariable Long orderId) {
        Optional<Order> orderById = orderService.findById(orderId);

        if (orderById.isEmpty()) {
            return new ResponseEntity<>("대상을 찾을 수 없습니다.",HttpStatus.BAD_REQUEST);
        }

        log.info("orderById={}", orderById);

        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }
}