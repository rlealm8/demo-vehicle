package com.vehicle.demo.util;

import com.vehicle.demo.model.Vehicle;
import com.vehicle.demo.model.dto.VehicleRequest;
import com.vehicle.demo.model.dto.VehicleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class RequestResponseFaker {

    public static VehicleRequest requestOk(){
        return VehicleRequest.builder()
                .brand("Toyota")
                .model("Yaris")
                .color("Azul")
                .year(2018)
                .licensePlate("ASD85P")
                .build();
    }

    public static VehicleResponse responseOk(){
        return VehicleResponse.builder()
                .id(1L)
                .brand("Toyota")
                .model("Yaris")
                .color("Azul")
                .year(2018)
                .licensePlate("ASD85P")
                .build();
    }

    public static Page<VehicleResponse> getListVehicleResponse(){
        List<VehicleResponse> listVehicles = new ArrayList<>();
        listVehicles.add(responseOk());
        return new PageImpl<>(listVehicles);
    }

    public static Page<Vehicle> getListVehicle(){
        List<Vehicle> listVehicles = new ArrayList<>();
        Vehicle vehicle = Vehicle.builder()
                .id(2L)
                .brand("Toyota")
                .model("Corolla")
                .color("Plateado")
                .year(2020)
                .licensePlate("ECU23L")
                .build();

        listVehicles.add(vehicleOk());
        listVehicles.add(vehicle);
        return new PageImpl<>(listVehicles);
    }

    public static Vehicle vehicleOk(){
        return Vehicle.builder()
                .id(1L)
                .brand("Toyota")
                .model("Yaris")
                .color("Azul")
                .year(2018)
                .licensePlate("ASD85P")
                .build();
    }
}
