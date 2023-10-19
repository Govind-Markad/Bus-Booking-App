package com.busBooking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class RoleDTO {

    private Long id;

    @NotEmpty(message = "Role name is required")
    private String roleName;

}
