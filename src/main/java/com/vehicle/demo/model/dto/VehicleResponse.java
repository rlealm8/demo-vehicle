package com.vehicle.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vehicle.demo.model.Vehicle;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VehicleResponse {

    @JsonProperty("marca")
    private String brand;

    @JsonProperty("modelo")
    private String model;

    @JsonProperty("matricula")
    private String vehicleRegistration;

    @JsonProperty("color")
    private String color;

    @JsonProperty("año")
    private Integer year;

    public static VehicleResponse of(Vehicle vehicle) {
        return VehicleResponse.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .vehicleRegistration(vehicle.getVehicleRegistration())
                .color(vehicle.getColor())
                .year(vehicle.getYear())
                .build();
    }
}
