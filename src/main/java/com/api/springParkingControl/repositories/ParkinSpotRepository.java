package com.api.springParkingControl.repositories;

import com.api.springParkingControl.models.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkinSpotRepository extends JpaRepository<ParkingSpotEntity, UUID> {

    boolean existsByLicensePlateCar(String licencePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
