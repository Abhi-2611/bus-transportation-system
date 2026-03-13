package com.transport.bus.service;

import java.util.List;

import com.transport.bus.dto.BusDto;

public interface BusService {

    BusDto createBus(BusDto busDTO);

    BusDto getBusById(Long busId);
    
    List<BusDto> getAllBuses();

    void deleteBus(Long busId);

}
