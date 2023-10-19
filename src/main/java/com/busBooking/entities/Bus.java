package com.busBooking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "buses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BusOperator")
    private BusOperator BusOperator;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "total_seats")
    private int totalSeats;

    private String amenities;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private Set<Schedule> schedules;

}
