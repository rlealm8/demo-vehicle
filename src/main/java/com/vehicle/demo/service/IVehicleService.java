package com.vehicle.demo.service;

import com.vehicle.demo.model.Vehicle;
import com.vehicle.demo.model.dto.VehicleRequest;
import com.vehicle.demo.model.dto.VehicleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IVehicleService {
    
    VehicleResponse save(VehicleRequest vehicleRequest);

    Vehicle find(Long vehicleId);

    Page<VehicleResponse> findList(String brand, String model, String vehicleRegistration, Pageable pageable);

    Page<VehicleResponse> findAllList(Pageable pageable);

    void delete(Long vehicleId);
    
}
