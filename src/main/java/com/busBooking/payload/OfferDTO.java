package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfferDTO {

    private Long id;

    @NotEmpty(message = "Offer name is required")
    private String offerName;

    @NotEmpty(message = "Promo code is required")
    private String promoCode;

    @NotEmpty(message = "Discount type is required")
    private String discountType;

    @NotNull(message = "Discount value is required")
    private Double discountValue;

    @Future(message = "Start date must be in the future")
    private Date startDate;

    @Future(message = "End date must be in the future")
    private Date endDate;

}
