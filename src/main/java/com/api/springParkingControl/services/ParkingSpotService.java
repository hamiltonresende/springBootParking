package com.api.springParkingControl.services;

import com.api.springParkingControl.models.ParkingSpotEntity;
import com.api.springParkingControl.repositories.ParkinSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    ParkinSpotRepository parkinSpotRepository;

    @Transactional
    public ParkingSpotEntity save(ParkingSpotEntity parkingSpotEntity) {
        return parkinSpotRepository.save(parkingSpotEntity);
    }

    public List<ParkingSpotEntity> findAll() {
        return parkinSpotRepository.findAll();
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkinSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkinSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkinSpotRepository.existsByApartmentAndBlock(apartment, block);
    }
}
