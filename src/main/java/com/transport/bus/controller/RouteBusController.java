package com.transport.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transport.bus.dto.BusDto;
import com.transport.bus.service.RouteBusService;
import com.transport.bus.util.ApiResponse;

@RestController
@RequestMapping("/api/routeBus")
public class RouteBusController {

    @Autowired
    private final RouteBusService routeBusService;

    public RouteBusController(RouteBusService routeBusService) {
        this.routeBusService = routeBusService;
    }

    @PostMapping("/mapping")
    public ResponseEntity<ApiResponse<BusDto>> mapBusToRoute(
            @RequestParam Long busId,
            @RequestParam Long routeId) {

        BusDto bus = routeBusService.mapBusToRoute(busId, routeId);

        ApiResponse<BusDto> response = ApiResponse.<BusDto>builder()
                .success(true)
                .message("Bus mapped to route successfully")
                .data(bus)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buses")
    public ResponseEntity<ApiResponse<List<BusDto>>> getBusesByRoute(@RequestParam Long routeId) {

        List<BusDto> buses = routeBusService.getBusesByRoute(routeId);

        ApiResponse<List<BusDto>> response = ApiResponse.<List<BusDto>>builder()
                .success(true)
                .message("Buses fetched successfully")
                .data(buses)
                .build();

        return ResponseEntity.ok(response);
    }

}