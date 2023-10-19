package com.busBooking.repository;

import com.busBooking.entities.UserOffers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOfferRepository extends JpaRepository <UserOffers,Long>{

}
