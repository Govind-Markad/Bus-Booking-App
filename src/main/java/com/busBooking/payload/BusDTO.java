package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BusDTO {

    private Long id;
    private Long operatorId;

    @NotEmpty(message = "Bus type is required")
    private String busType;

    @NotNull(message = "seats cannot be empty")
    private Integer totalSeats;


    private String amenities;
}
