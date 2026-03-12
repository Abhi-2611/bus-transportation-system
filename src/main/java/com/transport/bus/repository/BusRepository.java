package com.transport.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.bus.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}