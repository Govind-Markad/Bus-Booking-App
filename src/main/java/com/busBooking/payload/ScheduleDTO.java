package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class ScheduleDTO {

    private Long id;

    @NotNull(message = "Bus ID is required")
    private Long busId;

    @NotNull(message = "Route ID is required")
    private Long routeId;

    @Future(message = "Departure time must be in the future")
    private Date departureTime;

    @Future(message = "Arrival time must be in the future")
    private Date arrivalTime;

    @NotNull(message = "price can not empty")
    private double price;
}

