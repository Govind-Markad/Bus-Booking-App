package com.busBooking.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password_hash")
    private String passwordHash;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRoles> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserPaymentMethods> userPaymentMethods;

    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedback;
}
