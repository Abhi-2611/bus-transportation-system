package com.transport.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transport.bus.dto.RouteDto;
import com.transport.bus.service.RouteService;
import com.transport.bus.util.ApiResponse;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<RouteDto>> createRoute(@RequestBody RouteDto routeDto) {

        RouteDto savedRoute = routeService.createRoute(routeDto);

        ApiResponse<RouteDto> response = ApiResponse.<RouteDto>builder()
                .success(true)
                .message("Route created successfully")
                .data(savedRoute)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById")
    public ResponseEntity<ApiResponse<RouteDto>> getRouteById(@RequestParam Long routeId) {

        RouteDto route = routeService.getRouteById(routeId);

        ApiResponse<RouteDto> response = ApiResponse.<RouteDto>builder()
                .success(true)
                .message("Route fetched successfully")
                .data(route)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<RouteDto>>> getAllRoutes() {

        List<RouteDto> routes = routeService.getAllRoutes();

        ApiResponse<List<RouteDto>> response = ApiResponse.<List<RouteDto>>builder()
                .success(true)
                .message("Routes fetched successfully")
                .data(routes)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> deleteRoute(@RequestParam Long routeId) {

        routeService.deleteRoute(routeId);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Route deleted successfully")
                .data(null)
                .build();

        return ResponseEntity.ok(response);
    }

}