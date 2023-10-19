package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class RouteDTO {

    private Long id;

    @NotEmpty(message = "Origin is required")
    private String origin;

    @NotEmpty(message = "Destination is required")
    private String destination;

    @Positive(message = "Distance must be a positive value")
    private double distance;

    // Additional fields, getters, and setters
}

