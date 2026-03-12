package com.transport.bus.mapper;

import org.springframework.beans.BeanUtils;

import com.transport.bus.dto.BusDto;
import com.transport.bus.dto.RouteDto;
import com.transport.bus.entity.Bus;
import com.transport.bus.entity.Route;

public class TransportMapper {

    public static Route mapToRoute(RouteDto routeDto) {

        Route route = new Route();

        BeanUtils.copyProperties(routeDto, route);

        return route;
    }

    public static RouteDto mapToRouteDto(Route route) {

        RouteDto routeDto = new RouteDto();

        BeanUtils.copyProperties(route, routeDto);

        return routeDto;
    }

    public static Bus mapToBus(BusDto busDto) {

        Bus bus = new Bus();

        BeanUtils.copyProperties(busDto, bus);

        return bus;
    }

    public static BusDto mapToBusDto(Bus bus) {

        BusDto busDto = new BusDto();

        BeanUtils.copyProperties(bus, busDto);

        if (bus.getRoute() != null) {
            busDto.setRouteId(bus.getRoute().getId());
        }

        return busDto;
    }

}