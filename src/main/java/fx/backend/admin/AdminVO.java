package fx.backend.admin;

import fx.backend.domain.OrderStatus;
import lombok.Data;
import lombok.Getter;

@Getter
public class AdminVO {
    String password;
    OrderStatus status;
}
