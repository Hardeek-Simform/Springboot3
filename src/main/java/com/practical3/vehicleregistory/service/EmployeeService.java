package com.practical3.vehicleregistory.service;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.exception.UserNotFoundException;
import com.practical3.vehicleregistory.repository.UserVehicleRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    public ArrayList<UserVehicle> displayAll() {
        return UserVehicleRepo.getUsersVehList();
    }

    public void deleteEntry(int billNo) {
        ArrayList<UserVehicle> usersVehList = UserVehicleRepo.getUsersVehList();
        UserVehicle userVeh = usersVehList.stream().filter(user -> user.getBillNo() == billNo).findFirst().get();
        if (userVeh == null) {
            throw new UserNotFoundException();
        } else {
            usersVehList.remove(userVeh);
        }
        UserVehicleRepo.setUsersVehList(usersVehList);
    }
}
