package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PassengerDTO {

    private Long id;

    @NotNull(message = "Booking ID is required")
    private Long bookingId;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "age is required")
    private Integer age;

    @NotEmpty(message = "gender is required")
    private String gender;

    @NotNull(message = "seat number can not be empty")
    private Integer seatNumber;

}

