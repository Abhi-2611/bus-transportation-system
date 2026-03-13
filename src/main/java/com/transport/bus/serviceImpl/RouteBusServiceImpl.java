package com.transport.bus.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.bus.dto.BusDto;
import com.transport.bus.entity.Bus;
import com.transport.bus.entity.Route;
import com.transport.bus.exception.ResourceNotFoundException;
import com.transport.bus.mapper.TransportMapper;
import com.transport.bus.repository.BusRepository;
import com.transport.bus.repository.RouteRepository;
import com.transport.bus.service.RouteBusService;

@Service
public class RouteBusServiceImpl implements RouteBusService {

    @Autowired
    private final BusRepository busRepository;
    
    @Autowired
    private final RouteRepository routeRepository;

    public RouteBusServiceImpl(BusRepository busRepository, RouteRepository routeRepository) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public BusDto mapBusToRoute(Long busId, Long routeId) {

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id: " + busId));

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));

        bus.setRoute(route);

        Bus updatedBus = busRepository.save(bus);

        return TransportMapper.mapToBusDto(updatedBus);
    }

    @Override
    public List<BusDto> getBusesByRoute(Long routeId) {

        List<Bus> buses = busRepository.findByRouteId(routeId);

        return buses.stream()
                .map(TransportMapper::mapToBusDto)
                .collect(Collectors.toList());
    }

}