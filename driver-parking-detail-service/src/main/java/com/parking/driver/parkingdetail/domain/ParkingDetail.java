package com.parking.driver.parkingdetail.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ParkingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private Long parkingLotId;
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double cost;

    public ParkingDetail() {
    }

    public ParkingDetail(Long id, String licensePlate, Long parkingLotId, Long userId, LocalDateTime startTime, LocalDateTime endTime, Double cost) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingLotId = parkingLotId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
