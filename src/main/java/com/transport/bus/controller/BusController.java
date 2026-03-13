package com.transport.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transport.bus.dto.BusDto;
import com.transport.bus.service.BusService;
import com.transport.bus.util.ApiResponse;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<BusDto>> createBus(@RequestBody BusDto busDto) {

        BusDto bus = busService.createBus(busDto);

        ApiResponse<BusDto> response = ApiResponse.<BusDto>builder()
                .success(true)
                .message("Bus created successfully")
                .data(bus)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById")
    public ResponseEntity<ApiResponse<BusDto>> getBusById(@RequestParam Long busId) {

        BusDto bus = busService.getBusById(busId);

        ApiResponse<BusDto> response = ApiResponse.<BusDto>builder()
                .success(true)
                .message("Bus fetched successfully")
                .data(bus)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<BusDto>>> getAllBuses() {

        List<BusDto> buses = busService.getAllBuses();

        ApiResponse<List<BusDto>> response = ApiResponse.<List<BusDto>>builder()
                .success(true)
                .message("Buses fetched successfully")
                .data(buses)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> deleteBus(@RequestParam Long busId) {

        busService.deleteBus(busId);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Bus deleted successfully")
                .data(null)
                .build();

        return ResponseEntity.ok(response);
    }

}