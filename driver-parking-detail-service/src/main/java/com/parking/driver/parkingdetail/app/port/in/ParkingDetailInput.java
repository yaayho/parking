package com.parking.driver.parkingdetail.app.port.in;

import com.parking.driver.parkingdetail.domain.ParkingDetail;

import java.util.List;

public interface ParkingDetailInput {
    List<ParkingDetail> getParkingDetailsByUserId(Long userId);
    List<ParkingDetail> getParkingDetailsByLicensePlate(String licensePlate);
    ParkingDetail saveParkingDetail(ParkingDetail parkingDetail);
}
