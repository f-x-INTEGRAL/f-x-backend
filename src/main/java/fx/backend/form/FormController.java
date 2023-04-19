package fx.backend.form;

import fx.backend.domain.OrderStatus;
import fx.backend.domain.Orders;
import fx.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.LimitExceededException;


@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FormController {

    private final OrderService orderService;

    /**
     * Body 의 메세지를 받아 저장하고, 그 과정에서 같은 유저가 있는지 검증한다.
     *
     * @param order
     * @return HttpStatus 201, 409
     */

    @PostMapping("/form/save")
    public ResponseEntity<?> fromSave(@Validated @ModelAttribute SaveFormData saveFormData, BindingResult bindingResult) throws LimitExceededException {

        if(bindingResult.hasErrors()){
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        orderService.validateConformedQuantity();

        Orders orders = new Orders(
                saveFormData.getName(),
                saveFormData.getQuantity(),
                saveFormData.getPhoneNumber(),
                saveFormData.getBankName()
        );
        orderService.save(orders);
        log.info("order={}", orders);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * GET 요청으로 orderId를 받아, 해당 orderId에 맞는 order 를 반환 한다
     *
     * @param orderId
     * @return Order
     */

//    @GetMapping("/form/{orderId}")
//    public ResponseEntity<Orders> findOrderById(@PathVariable Long orderId) {
//        Orders orderById = orderService.findById(orderId);
//        log.info("orderById={}", orderById);
//
//        return ResponseEntity.ok(orderById);
//    }
}
