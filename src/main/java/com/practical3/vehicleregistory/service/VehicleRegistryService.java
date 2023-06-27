package com.practical3.vehicleregistory.service;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.dto.VerifierDTO;
import com.practical3.vehicleregistory.entity.dto.mapper.VerifierDTOMapper;
import com.practical3.vehicleregistory.repository.UserVehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleRegistryService {
    @Autowired
    VerifierDTOMapper verifierDTOMapper;

    public VerifierDTO getVehicleVerification(String vehicleNo) {


        Optional<UserVehicle> optionalUserDTO = UserVehicleRepo.getUsersVehList().stream().filter(user -> user.getVehicleNumber().equalsIgnoreCase(vehicleNo)).findFirst();
        if (optionalUserDTO.isPresent()) {
            UserVehicle vehicle = optionalUserDTO.get();
            VerifierDTO verifierDTO = verifierDTOMapper.apply(vehicle);
            return verifierDTO;
        } else {
            return null;
        }
    }
}


