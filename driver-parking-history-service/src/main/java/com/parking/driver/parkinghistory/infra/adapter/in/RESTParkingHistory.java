package com.parking.driver.parkinghistory.infra.adapter.in;

import com.parking.driver.parkinghistory.app.port.in.ParkingHistoryInput;
import com.parking.driver.parkinghistory.domain.ParkingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking-history")
public class RESTParkingHistory {

    @Autowired
    private ParkingHistoryInput service;

    @PostMapping
    public ResponseEntity<ParkingHistory> saveParkingHistory(@RequestBody ParkingHistory parkingHistory) {
        return ResponseEntity.ok(service.saveParkingHistory(parkingHistory));
    }

    @GetMapping
    public ResponseEntity<List<ParkingHistory>> getAllParkingHistories() {
        return ResponseEntity.ok(service.getAllParkingHistory());
    }

    @GetMapping("/{vehiclePlate}")
    public ResponseEntity<List<ParkingHistory>> getParkingHistoryById(@PathVariable String  vehiclePlate) {
        return ResponseEntity.ok(service.getParkingHistoryByVehiclePlate(vehiclePlate));
    }

}
