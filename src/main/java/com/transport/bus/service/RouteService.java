package com.transport.bus.service;

import java.util.List;

import com.transport.bus.dto.RouteDto;

public interface RouteService {

    RouteDto createRoute(RouteDto routeDto);

    RouteDto getRouteById(Long routeId);

    List<RouteDto> getAllRoutes();

    void deleteRoute(Long routeId);

}
