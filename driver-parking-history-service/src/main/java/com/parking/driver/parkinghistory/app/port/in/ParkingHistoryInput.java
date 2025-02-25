package com.parking.driver.parkinghistory.app.port.in;

import com.parking.driver.parkinghistory.domain.ParkingHistory;

import java.util.List;

public interface ParkingHistoryInput {

    // Método para obtener el historial de parqueos por la placa del vehículo
    List<ParkingHistory> getParkingHistoryByVehiclePlate(String vehiclePlate);

    // Método para guardar un nuevo registro de parqueo
    ParkingHistory saveParkingHistory(ParkingHistory parkingHistory);

    // Método para obtener todos los registros de historial de parqueo
    List<ParkingHistory> getAllParkingHistory();
}
