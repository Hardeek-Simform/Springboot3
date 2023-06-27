package com.practical3.vehicleregistory.entity.dto.mapper;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOToUserVehicleMapper implements Function<UserDTO, UserVehicle> {
    @Override
    public UserVehicle apply(UserDTO userDTO) {
        UserVehicle userVehicle = new UserVehicle();
        userVehicle.setBillNo(userDTO.billNo());
        userVehicle.setUserName(userDTO.UserName());
        userVehicle.setVehicleName(userDTO.vehicleName());
        userVehicle.setVehicleNumber(userDTO.vehicleNumber());
        userVehicle.setVehicleCategory(userDTO.vehicleCategory());
        return userVehicle;
    }
}

