package com.busBooking.payload;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;


    @NotEmpty(message = "Password is required")
    private String password;

    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Invalid phone number")
    @NotEmpty(message = "Phone number is required")

    private String phoneNumber;

    private String profilePicture;

    private MultipartFile profileImage;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
