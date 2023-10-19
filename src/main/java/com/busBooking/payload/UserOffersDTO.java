package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOffersDTO {

    private Long userId;

    private Long offerId;

}
