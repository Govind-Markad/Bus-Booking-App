package com.busBooking.controller;

import com.busBooking.entities.Bus;
import com.busBooking.entities.BusOperator;
import com.busBooking.entities.Route;
import com.busBooking.entities.Schedule;
import com.busBooking.service.BusOperatorService;
import com.busBooking.service.BusService;
import com.busBooking.service.RouteService;
import com.busBooking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BusOperatorService busOperatorService;
    private final ScheduleService scheduleService;
    private final RouteService routeService;
    private final BusService busService;

    @Autowired
    public BookingController(
            BusOperatorService busOperatorService,
            ScheduleService scheduleService,
            RouteService routeService,
            BusService busService
    ) {
        this.busOperatorService = busOperatorService;
        this.scheduleService = scheduleService;
        this.routeService = routeService;
        this.busService = busService;
    }

    // BusOperator API endpoints
    @PostMapping("/bus-operators")
    public ResponseEntity<BusOperator> createBusOperator(@RequestBody BusOperator busOperator) {
        BusOperator createdBusOperator = busOperatorService.createBusOperator(busOperator);
        return  new ResponseEntity<>(createdBusOperator, HttpStatus.CREATED);
    }

    // Bus API endpoints
    @PostMapping("/buses")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus createdBus = busService.createBus(bus);
        return ResponseEntity.ok(createdBus);
    }

    // Schedule API endpoints
    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleService.createSchedule(schedule);
        return ResponseEntity.ok(createdSchedule);
    }

    // Route API endpoints
    @PostMapping("/routes")
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route createdRoute = routeService.createRoute(route);
        return ResponseEntity.ok(createdRoute);
    }

}
