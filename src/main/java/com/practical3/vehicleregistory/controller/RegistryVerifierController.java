package com.practical3.vehicleregistory.controller;

import com.practical3.vehicleregistory.entity.dto.VerifierDTO;
import com.practical3.vehicleregistory.service.VehicleRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/verifier")
public class RegistryVerifierController {
    private static int vehicleSearch = 0;
    @Autowired
    VehicleRegistryService vehicleRegistryService;

    @GetMapping("/{vehicleNo}")
    public VerifierDTO getVerificationRegistryByVehicleNo(@PathVariable("vehicleNo") String vehicleNo) {
        vehicleSearch++;
        log.info("Inside RegistryVerifierController, Vehicle Search called:" + vehicleSearch);
        VerifierDTO verifierDTO = vehicleRegistryService.getVehicleVerification(vehicleNo);
        return verifierDTO;
    }
}
