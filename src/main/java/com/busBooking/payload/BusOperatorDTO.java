package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class BusOperatorDTO {

    private Long id;

    @NotEmpty(message = "Operator name is required")
    private String operatorName;

    @Email(message = "Invalid email address")
    @NotEmpty(message = "Contact email is required")
    private String contactEmail;

    @NotEmpty(message = "Contact phone is required")
    private String contactPhone;

    private String logoUrl;
}

