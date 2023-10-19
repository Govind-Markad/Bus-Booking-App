package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BookingDTO {

    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Schedule ID is required")
    private Long scheduleId;

    @NotNull(message = "passenger can not be empty")
    private Integer totalPassengers;

    @NotNull(message = "amount can not empty")
    private double totalAmount;

    private Long paymentMethodId;
    private String status;



}

