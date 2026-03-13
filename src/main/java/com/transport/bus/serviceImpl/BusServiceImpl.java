package com.transport.bus.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.bus.dto.BusDto;
import com.transport.bus.entity.Bus;
import com.transport.bus.exception.ResourceNotFoundException;
import com.transport.bus.mapper.TransportMapper;
import com.transport.bus.repository.BusRepository;
import com.transport.bus.service.BusService;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public BusDto createBus(BusDto busDto) {

        Bus bus = new Bus();

        if (busDto.getId() != null) {

            bus = busRepository.findById(busDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id: " + busDto.getId()));

            if (busDto.getBusNo() != null) {
                bus.setBusNo(busDto.getBusNo());
            }

            if (busDto.getColor() != null) {
                bus.setColor(busDto.getColor());
            }

            if (busDto.getCapacity() != null) {
                bus.setCapacity(busDto.getCapacity());
            }

        } else {

            bus = TransportMapper.mapToBus(busDto);

        }

        Bus savedBus = busRepository.save(bus);

        return TransportMapper.mapToBusDto(savedBus);
    }

    @Override
    public BusDto getBusById(Long busId) {

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id: " + busId));

        return TransportMapper.mapToBusDto(bus);
    }

    @Override
    public List<BusDto> getAllBuses() {

        List<Bus> buses = busRepository.findAll();
        //filtering in java bcoz system is small if large then repo filtering better
        return buses.stream()
                .filter(bus -> bus.getActiveFlag() != null && bus.getActiveFlag() == 'Y')
                .map(TransportMapper::mapToBusDto)
                .collect(Collectors.toList());
    }

    // soft delete bus from db
    @Override
    public void deleteBus(Long busId) {

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id: " + busId));

        bus.setActiveFlag('N');
        busRepository.save(bus);
    }

}