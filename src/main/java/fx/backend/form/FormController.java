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
        try {
            orderService.save(order);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/form/find/{orderid}")
    public ResponseEntity<?> findOrderById(@PathVariable Long orderid) {
         Optional<Order> order = orderService.findById(orderid);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}