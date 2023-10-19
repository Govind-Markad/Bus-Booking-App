package com.busBooking.payload;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserPaymentMethodDTO {

    private Long id;

    private Long userId;

    @NotEmpty(message = "Payment type is required")
    private String paymentType;

    @NotEmpty(message = "Card number is required")
    private String cardNumber;

    @NotEmpty(message = "Expiration date is required")
    private String expirationDate;

    @NotEmpty(message = "Card holder name is required")
    private String cardHolderName;

}
