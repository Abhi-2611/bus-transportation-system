package com.transport.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.bus.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}