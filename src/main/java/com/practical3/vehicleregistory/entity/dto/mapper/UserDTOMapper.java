package com.practical3.vehicleregistory.entity.dto.mapper;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<UserVehicle, UserDTO> {
    @Override
    public UserDTO apply(UserVehicle userVehicle) {
        UserDTO userDTO = new UserDTO(userVehicle.getBillNo(), userVehicle.getUserName(), userVehicle.getVehicleName(), userVehicle.getVehicleNumber(), userVehicle.getVehicleCategory());
        return userDTO;
    }
}