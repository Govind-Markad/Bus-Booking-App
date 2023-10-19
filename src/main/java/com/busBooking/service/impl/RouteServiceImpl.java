package com.busBooking.service.impl;

import com.busBooking.entities.Route;
import com.busBooking.repository.RouteRepository;
import com.busBooking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route createRoute(Route route){
        return routeRepository.save(route);
    }
}
