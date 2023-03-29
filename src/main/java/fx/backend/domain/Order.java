package fx.backend.domain;

import lombok.Data;

@Data
public class Order {
    private Long ID;
    private String name;
    private Integer headCount;
    private Long phoneNumber;
    private String bankName;
    private OrderStatus status = OrderStatus.WAITING;

    public Order(String name, Integer headCount, Long phoneNumber, String bankName) {
        this.name = name;
        this.headCount = headCount;
        this.phoneNumber = phoneNumber;
        this.bankName = bankName;
    }
}
