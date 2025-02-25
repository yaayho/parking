package com.parking.driver.parkingdetail.infra.adapter.in;

import com.parking.driver.parkingdetail.app.port.in.ParkingDetailInput;
import com.parking.driver.parkingdetail.domain.ParkingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking-details")
public class RESTParkingDetail {

    @Autowired
    private ParkingDetailInput parkingDetailService;

    @GetMapping("/user/{userId}")
    public List<ParkingDetail> getParkingDetailsByUserId(@PathVariable Long userId) {
        return parkingDetailService.getParkingDetailsByUserId(userId);
    }

    @GetMapping("/license-plate/{licensePlate}")
    public List<ParkingDetail> getParkingDetailsByLicensePlate(@PathVariable String licensePlate) {
        return parkingDetailService.getParkingDetailsByLicensePlate(licensePlate);
    }

    @PostMapping
    public ParkingDetail saveParkingDetail(@RequestBody ParkingDetail parkingDetail) {
        return parkingDetailService.saveParkingDetail(parkingDetail);
    }
}
