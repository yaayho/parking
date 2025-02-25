package com.parking.driver.parkingdetail.app.port.out;

import com.parking.driver.parkingdetail.domain.ParkingDetail;

import java.util.List;


public interface ParkingDetailOutput {

    List<ParkingDetail> findByUserId(Long userId);
    List<ParkingDetail> findByLicensePlate(String licensePlate);
    ParkingDetail save(ParkingDetail entity);
}
