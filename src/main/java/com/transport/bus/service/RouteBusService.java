package com.transport.bus.service;

import java.util.List;

import com.transport.bus.dto.BusDto;

public interface RouteBusService {

    BusDto mapBusToRoute(Long busId, Long routeId);

    List<BusDto> getBusesByRoute(Long routeId);

}