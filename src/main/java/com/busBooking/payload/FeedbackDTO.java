package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FeedbackDTO {

    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "can not empty")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private int rating;

    @NotEmpty(message = "Comments are required")
    private String comments;

}
