package com.busBooking.service.impl;

import com.busBooking.entities.Bus;
import com.busBooking.repository.BusRepository;
import com.busBooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus createBus(Bus bus){
        return busRepository.save(bus);
    }
}
