package com.vehicle.demo.service.impl;

import com.vehicle.demo.model.Vehicle;
import com.vehicle.demo.model.dto.VehicleRequest;
import com.vehicle.demo.model.dto.VehicleResponse;
import com.vehicle.demo.repository.VehicleRepository;
import com.vehicle.demo.service.IVehicleService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @SneakyThrows
    public VehicleResponse save(VehicleRequest vehicleRequest) {
        //Metodo para guardar y actualizar vehiculos
        return VehicleResponse.of(vehicleRepository.save(vehicleRequest.toDomain()));
    }

    @Override
    public Vehicle find(Long vehicleId) {
        //Metodo para consultar vehiculo por ID
        return vehicleRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Page<VehicleResponse> findList(String brand, String model, String vehicleRegistration, Pageable pageable) {
        //Metodo para obtener el listado de vehiculos segun parametros marca, modelo y matricula paginado y en orden
        return vehicleRepository.findByBrandContainingOrModelContainingOrLicensePlateContainingOrderByIdDesc(brand, model,
                vehicleRegistration, pageable).map(entity -> VehicleResponse.of(entity));
    }

    @Override
    public Page<VehicleResponse> findAllList(Pageable pageable) {
        //Metodo para obtener el listado de vehiculos paginado y en orden
        return vehicleRepository.findAllByOrderByIdDesc(pageable).map(entity -> VehicleResponse.of(entity));
    }

    @Override
    public void delete(Long vehicleId) {
        //Metodo para eliminar vehiculo por ID
        vehicleRepository.deleteById(vehicleId);
    }

}
