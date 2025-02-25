package com.parking.driver.parkingdetail.app;

import com.parking.driver.parkingdetail.app.port.in.ParkingDetailInput;
import com.parking.driver.parkingdetail.domain.ParkingDetail;
import com.parking.driver.parkingdetail.app.port.out.ParkingDetailOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingDetailUserCase implements ParkingDetailInput {

    @Autowired
    private ParkingDetailOutput repository;

    @Override
    public List<ParkingDetail> getParkingDetailsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ParkingDetail> getParkingDetailsByLicensePlate(String licensePlate) {
        return repository.findByLicensePlate(licensePlate);
    }

    @Override
    public ParkingDetail saveParkingDetail(ParkingDetail parkingDetail) {
        return repository.save(parkingDetail);
    }
}
