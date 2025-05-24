package com.travelapi3.repository;

import com.travelapi3.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {
}