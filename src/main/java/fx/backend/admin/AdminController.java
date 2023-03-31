package fx.backend.admin;

import fx.backend.domain.Order;
import fx.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final OrderService orderService;

    @PatchMapping("/edit")
    public HttpStatus editOrder(Long orderId, @ModelAttribute Order order) {

        return HttpStatus.OK;
    }

    /**
     * 요청이 들어오면 모든 order 를 반환함
     *
     * @return
     */

    @PostMapping("/find-all")
    public List<Order> findAllOrder() {
        return orderService.findAll();
    }
}
