package com.busBooking.service.impl;
import com.busBooking.entities.BusOperator;
import com.busBooking.repository.BusOperatorRepository;
import com.busBooking.service.BusOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {

    private final BusOperatorRepository busOperatorRepository;

    @Autowired
    public BusOperatorServiceImpl(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    @Override
    public BusOperator createBusOperator(BusOperator busOperator) {
        return busOperatorRepository.save(busOperator);
    }
}







