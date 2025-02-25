package com.parking.driver.parkinghistory.app;

import com.parking.driver.parkinghistory.app.port.in.ParkingHistoryInput;
import com.parking.driver.parkinghistory.app.port.out.ParkingHistoryOutput;
import com.parking.driver.parkinghistory.domain.ParkingHistory;
import com.parking.driver.parkinghistory.infra.adapter.out.JPARepositoryParkingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParkingHistoryUserCase implements ParkingHistoryInput {

    @Autowired
    private ParkingHistoryOutput repository;

    @Override
    @Transactional(readOnly = true)
    public List<ParkingHistory> getParkingHistoryByVehiclePlate(String vehiclePlate) {
        return repository.findByVehiclePlate(vehiclePlate);
    }

    @Override
    @Transactional
    public ParkingHistory saveParkingHistory(ParkingHistory parkingHistory) {
        return repository.save(parkingHistory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParkingHistory> getAllParkingHistory() {
        return (List<ParkingHistory>) repository.findAll();
    }
}
