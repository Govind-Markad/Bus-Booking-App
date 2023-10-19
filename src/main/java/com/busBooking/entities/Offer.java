package com.busBooking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "offers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_name")
    private String offerName;

    @Column(name = "promo_code")
    private String promoCode;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_value")
    private double discountValue;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "offer",cascade = CascadeType.ALL)
    private Set<UserOffers> userOffers;

}
