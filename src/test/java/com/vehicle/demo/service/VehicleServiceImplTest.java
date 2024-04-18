package com.vehicle.demo.service;

import com.vehicle.demo.model.dto.VehicleResponse;
import com.vehicle.demo.repository.VehicleRepository;
import com.vehicle.demo.service.impl.VehicleServiceImpl;
import com.vehicle.demo.util.RequestResponseFaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;
    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    @DisplayName("When save vehicle is ok")
    public void whenSaveVehicleOk() throws Exception {

        when(vehicleRepository.save(any()))
                .thenReturn(RequestResponseFaker.vehicleOk());

        VehicleResponse vehicle = vehicleService.save(RequestResponseFaker.requestOk());

        Assertions.assertEquals("Toyota", vehicle.getBrand());

    }

    @Test
    @DisplayName("When update vehicle is ok")
    public void whenUpdateVehicleOk() throws Exception {

        when(vehicleRepository.save(any()))
                .thenReturn(RequestResponseFaker.vehicleOk());

        VehicleResponse vehicle = vehicleService.save(RequestResponseFaker.requestOk());

        Assertions.assertEquals("Toyota", vehicle.getBrand());

    }

    @Test
    @DisplayName("When delete vehicle is ok")
    public void whenDeleteVehicleOk() throws Exception {

        vehicleService.delete(1L);

        Assertions.assertAll(() -> vehicleService.delete(1L));

    }

    @Test
    @DisplayName("When get vehicle is ok")
    public void whenGetVehicleOk() throws Exception {

        when(vehicleRepository.findByBrandContainingOrModelContainingOrLicensePlateContainingOrderByIdDesc(anyString(),
                anyString(), anyString(), any())).thenReturn(RequestResponseFaker.getListVehicle());

        Page<VehicleResponse> listVehicle = vehicleService.findList("Toyota", "", "", Pageable.unpaged());

        Assertions.assertEquals(2, listVehicle.getTotalElements());
        Assertions.assertEquals("Yaris", listVehicle.getContent().get(0).getModel());
        Assertions.assertEquals("Corolla", listVehicle.getContent().get(1).getModel());

    }

}
