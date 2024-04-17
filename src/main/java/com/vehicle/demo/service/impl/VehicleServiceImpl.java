package com.vehicle.demo.service.impl;

import com.vehicle.demo.model.dto.VehicleRequest;
import com.vehicle.demo.model.dto.VehicleResponse;
import com.vehicle.demo.repository.VehicleRepository;
import com.vehicle.demo.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public VehicleResponse save(VehicleRequest vehicleRequest) {
        return VehicleResponse.of(vehicleRepository.save(vehicleRequest.toDomain()));
    }

    @Override
    public VehicleResponse find(Long vehicleId) {
        return VehicleResponse.of(vehicleRepository.findById(vehicleId).get());
    }

    @Override
    public Page<VehicleResponse> findList(String brand, String model, String vehicleRegistration, Pageable pageable) {
        return vehicleRepository.findByBrandContainingOrModelContainingOrVehicleRegistrationContaining(brand, model,
                vehicleRegistration, pageable).map(entity -> VehicleResponse.of(entity));
    }

    @Override
    public void delete(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

}
