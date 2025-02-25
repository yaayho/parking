package com.parking.driver.parkinghistory.infra.adapter.out;

import com.parking.driver.parkinghistory.app.port.out.ParkingHistoryOutput;
import com.parking.driver.parkinghistory.domain.ParkingHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JPARepositoryParkingHistory extends ParkingHistoryOutput, CrudRepository<ParkingHistory, Long> {

    // Agregamos un método para buscar por la placa del vehículo
    List<ParkingHistory> findByVehiclePlate(String vehiclePlate);
}
