package com.vehicle.demo.controller;

import com.vehicle.demo.model.dto.VehicleRequest;
import com.vehicle.demo.model.dto.VehicleResponse;
import com.vehicle.demo.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    
    @Autowired
    IVehicleService iVehicleService;

    @PostMapping("/save")
    public ResponseEntity<VehicleResponse> save(@RequestBody VehicleRequest vehicle) {
        return ResponseEntity.status(HttpStatus.OK).body(iVehicleService.save(vehicle));
    }

    @PutMapping("/update")
    public ResponseEntity<VehicleResponse> update(@RequestBody VehicleRequest vehicle) {
        return ResponseEntity.status(HttpStatus.OK).body(iVehicleService.save(vehicle));
    }

    @DeleteMapping("/delete/{vehicleId}")
    public void delete(@PathVariable Long vehicleId){
        iVehicleService.delete(vehicleId);
    }

    @GetMapping("/filtro")
    public Page<VehicleResponse> buscarVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String license,
            Pageable pageable) {
        return iVehicleService.findList(brand, model, license, pageable);
    }
    
}
