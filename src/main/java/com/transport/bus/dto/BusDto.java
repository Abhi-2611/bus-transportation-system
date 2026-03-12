package com.transport.bus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {

    private Long id;

    private String busNo;

    private String color;

    private Integer capacity;

    private Character activeFlag;

    private Long routeId;

}