package com.travelapi3.repository;

import com.travelapi3.entity.Travelsignup3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Travelsignup3Repository extends JpaRepository<Travelsignup3, Integer> {
    Optional<Travelsignup3> findByUsername(String username);
}