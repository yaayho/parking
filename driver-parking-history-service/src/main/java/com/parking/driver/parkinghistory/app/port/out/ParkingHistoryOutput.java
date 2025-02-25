package com.parking.driver.parkinghistory.app.port.out;

import com.parking.driver.parkinghistory.domain.ParkingHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingHistoryOutput {

    // Agregamos un método para buscar por la placa del vehículo
    List<ParkingHistory> findByVehiclePlate(String vehiclePlate);

    ParkingHistory save(ParkingHistory entity);

    Iterable<ParkingHistory> findAll();
}
