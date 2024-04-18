package com.vehicle.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vehicle.demo.model.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleRequest {

    private Long id;

    @JsonProperty("marca")
    private String brand;

    @JsonProperty("modelo")
    private String model;

    @JsonProperty("matricula")
    private String licensePlate;

    @JsonProperty("color")
    private String color;

    @JsonProperty("año")
    private Integer year;

    public Vehicle toDomain() {
        return Vehicle.builder()
                .id(id)
                .brand(brand)
                .model(model)
                .licensePlate(licensePlate)
                .color(color)
                .year(year)
                .build();
    }
}
