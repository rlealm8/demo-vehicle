package com.vehicle.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.demo.service.IVehicleService;
import com.vehicle.demo.util.RequestResponseFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IVehicleService iVehicleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("When POST vehicle is called should return a response OK")
    public void whenSaveVehicleOk() throws Exception {

        when(iVehicleService.save(any())).thenReturn(RequestResponseFaker.responseOk());

        mockMvc.perform(post("/api/vehicle/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(RequestResponseFaker.requestOk())))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.marca", is("Toyota")));
    }

    @Test
    @DisplayName("When PUT vehicle is called should return a response OK")
    public void whenUpdateVehicleOk() throws Exception {

        when(iVehicleService.save(any())).thenReturn(RequestResponseFaker.responseOk());

        mockMvc.perform(put("/api/vehicle/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(RequestResponseFaker.requestOk())))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.marca", is("Toyota")));
    }

    @Test
    @DisplayName("When DELETE vehicle is called should return a response OK")
    public void whenDeleteVehicleOk() throws Exception {

        mockMvc.perform(delete("/api/vehicle/delete/{vehicleId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    @DisplayName("When GET vehicle is called should return a response OK")
    public void whenGetVehicleOk() throws Exception {

        when(iVehicleService.findList(anyString(), anyString(), anyString(), any())).thenReturn(RequestResponseFaker.getListVehicleResponse());

        mockMvc.perform(get("/api/vehicle/filtro?brand=Chevrolet&model=Spark&license=AS258F&page=0&size=10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(RequestResponseFaker.getListVehicleResponse())));

    }

    }
