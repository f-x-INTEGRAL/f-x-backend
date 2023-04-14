package fx.backend.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SaveFormData {
    @Null(message = "ID는 Null이어야 합니다.")
    private Integer ID;

    @NotNull(message = "이름은 공백일 수 없습니다.")
    @Length(min = 2, max = 5, message = "이름은 2 ~ 5 사이입니다.")
    private String name;

    @NotNull(message = "수량은 공백일 수 없습니다.")
    @Min(value = 1, message = "티켓은 최소 1장어야야 합니다.")
    @Max(value = 150, message = "티켓은 최대 150장 입니다.")
    private Integer quantity;

    @NotNull(message = "전화번호는 공백일 수 없습니다,")
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "전화번호 형식과 일치하지 않습니다.")
    private String phoneNumber;

    @NotNull(message = "입금자 명은 공백일 수 없습니다.")
    @Length(min = 2, max = 5, message = "이름은 2 ~ 5 사이입니다.")
    private String bankName;

    public SaveFormData(String name, Integer quantity, String phoneNumber, String bankName) {
        this.name = name;
        this.quantity = quantity;
        this.phoneNumber = phoneNumber;
        this.bankName = bankName;
    }
}
