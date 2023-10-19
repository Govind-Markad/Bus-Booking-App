package com.busBooking.repository;

import com.busBooking.entities.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {
    // Additional query methods if needed
}
