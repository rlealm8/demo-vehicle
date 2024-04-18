package com.vehicle.demo.repository;

import com.vehicle.demo.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Page<Vehicle> findByBrandContainingOrModelContainingOrLicensePlateContainingOrderByIdDesc(String brand, String model, String vehicleRegistration, Pageable pageable);

    Page<Vehicle> findAllByOrderByIdDesc(Pageable pageable);

}
