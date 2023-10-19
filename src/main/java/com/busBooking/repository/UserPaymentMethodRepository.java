package com.busBooking.repository;

import com.busBooking.entities.UserPaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethods, Long> {
    // Additional query methods if needed
}

