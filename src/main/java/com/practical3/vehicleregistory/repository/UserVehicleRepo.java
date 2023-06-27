package com.practical3.vehicleregistory.repository;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.enums.VehicleCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Slf4j
@Repository
public class UserVehicleRepo {
    @Getter
    @Setter
    private static ArrayList<UserVehicle> usersVehList = new ArrayList();

    static {
        usersVehList.add(new UserVehicle(1001, "Hardeek", "Activa", "GJ04BPL9099", VehicleCategory.PETROL, 51, "Rakesh"));
        usersVehList.add(new UserVehicle(1002, "Yash", "Ola", "GJ01tAL9989", VehicleCategory.ELECTRIC, 52, "Suresh"));
        usersVehList.add(new UserVehicle(1003, "Mihir", "Splendor", "GJ02BPT9045", VehicleCategory.PETROL, 53, "Mahesh"));
        log.info("Sample Data added in userVehicle repo");
    }
}
