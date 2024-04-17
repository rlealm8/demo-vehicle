package com.vehicle.demo.model.dto;

import com.vehicle.demo.model.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleRequest {

    private Long id;

    private String brand;

    private String model;

    private String vehicleRegistration;

    private String color;

    private Integer year;

    public Vehicle toDomain() {
        return Vehicle.builder()
                .id(id)
                .brand(brand)
                .model(model)
                .vehicleRegistration(vehicleRegistration)
                .color(color)
                .year(year)
                .build();
    }
}
