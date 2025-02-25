package com.parking.driver.parkingdetail.infra.adapter.out;

import com.parking.driver.parkingdetail.app.port.out.ParkingDetailOutput;
import com.parking.driver.parkingdetail.domain.ParkingDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepositoryParkingDetail extends ParkingDetailOutput,  CrudRepository<ParkingDetail, Long> {

}
