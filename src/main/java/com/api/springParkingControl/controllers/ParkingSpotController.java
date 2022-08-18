package com.api.springParkingControl.controllers;

import com.api.springParkingControl.dtos.ParkingSpotDTO;
import com.api.springParkingControl.models.ParkingSpotEntity;
import com.api.springParkingControl.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do carro já está em uso!");
        }
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já esta em uso!");
        }
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já está registrada para outro apartamento!");
        }
        var parkingSpotEntity = new ParkingSpotEntity();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotEntity);
        parkingSpotEntity.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotEntity));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotEntity>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }
}
