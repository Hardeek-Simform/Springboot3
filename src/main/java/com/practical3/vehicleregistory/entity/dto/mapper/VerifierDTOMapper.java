package com.practical3.vehicleregistory.entity.dto.mapper;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.dto.VerifierDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VerifierDTOMapper implements Function<UserVehicle, VerifierDTO> {
    @Override
    public VerifierDTO apply(UserVehicle userVehicle) {
        VerifierDTO verifierDTO = new VerifierDTO(userVehicle.getVehicleCategory(), userVehicle.getUserName(), userVehicle.getVehicleName(), userVehicle.getVehicleNumber());
        return verifierDTO;
    }
}