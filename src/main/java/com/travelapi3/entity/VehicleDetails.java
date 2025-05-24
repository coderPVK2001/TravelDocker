package com.travelapi3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicle_details")
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "modelname" ,unique=true)
    private String modelname;

    @Column(name = "origin")
    private String origin;

    @Column(name = "year")
    private Integer year;

}