package fx.backend.admin;

import fx.backend.domain.OrderStatus;
import fx.backend.domain.Orders;
import fx.backend.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.LimitExceededException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final OrderService orderService;

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session, @RequestBody AdminVO adminVO) {
        String password = adminVO.getPassword();

        if (orderService.login(password)) {
            session.setAttribute("password", password);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PatchMapping("/update/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long orderId, @RequestBody AdminVO adminVO, @SessionAttribute String password) throws LimitExceededException {
        orderService.validateConformedQuantity();

        OrderStatus status = adminVO.getStatus();
        Orders updateOrder = orderService.updateOrderStatus(orderId, status);

        return ResponseEntity.ok(updateOrder);
    }

    /**
     * 요청이 들어오면 모든 order 를 반환함
     *
     * @return
     */

    @GetMapping("/find-all")
    public List<Orders> findAllOrder(@SessionAttribute String password) {

        return orderService.findAll();
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId, @SessionAttribute String password) {
        orderService.deleteOrder(orderId);

        return ResponseEntity.ok().build();
    }

}
