package com.transport.bus.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.bus.dto.RouteDto;
import com.transport.bus.entity.Route;
import com.transport.bus.exception.ResourceNotFoundException;
import com.transport.bus.mapper.TransportMapper;
import com.transport.bus.repository.RouteRepository;
import com.transport.bus.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteDto createRoute(RouteDto routeDto) {

        Route route = new Route();

        if (routeDto.getId() != null) {

            route = routeRepository.findById(routeDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeDto.getId()));

            if (routeDto.getTitle() != null) {
                route.setTitle(routeDto.getTitle());
            }

            if (routeDto.getSource() != null) {
                route.setSource(routeDto.getSource());
            }

            if (routeDto.getDestination() != null) {
                route.setDestination(routeDto.getDestination());
            }

            if (routeDto.getStations() != null) {
                route.setStations(routeDto.getStations());
            }

        } else {

            route = TransportMapper.mapToRoute(routeDto);
            route.setActiveFlag('Y');

        }

        Route savedRoute = routeRepository.save(route);

        return TransportMapper.mapToRouteDto(savedRoute);
    }

    @Override
    public List<RouteDto> getAllRoutes() {

        List<Route> routes = routeRepository.findAll();

        //filtering in java bcoz system is small if large then repo filtering better
        return routes.stream()
                .filter(route -> route.getActiveFlag() != null && route.getActiveFlag() == 'Y')
                .map(TransportMapper::mapToRouteDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteDto getRouteById(Long routeId) {

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));
        return TransportMapper.mapToRouteDto(route);
    }

    // soft delete route from db
    @Override
    public void deleteRoute(Long routeId) {

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));

        route.setActiveFlag('N');
        routeRepository.save(route);
    }

}