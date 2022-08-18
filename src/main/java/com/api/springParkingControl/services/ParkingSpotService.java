package com.api.springParkingControl.services;

import com.api.springParkingControl.models.ParkingSpotEntity;
import com.api.springParkingControl.repositories.ParkinSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {

    @Autowired
    ParkinSpotRepository parkinSpotRepository;

    @Transactional
    public ParkingSpotEntity save(ParkingSpotEntity parkingSpotEntity) {
        return parkinSpotRepository.save(parkingSpotEntity);
    }
}
