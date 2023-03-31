package fx.backend.domain;

import lombok.Data;

@Data
public class Order {
    private Long ID;
    private String name;
    private Integer headCount;
    private String phoneNumber;
    private String bankName;
    private OrderStatus status = OrderStatus.WAITING;

    public Order(String name, Integer headCount, String phoneNumber, String bankName) {
        this.name = name;
        this.headCount = headCount;
        this.phoneNumber = phoneNumber;
        this.bankName = bankName;
    }
}
