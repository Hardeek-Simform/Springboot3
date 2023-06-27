package com.practical3.vehicleregistory.entity.dto;

import com.practical3.vehicleregistory.entity.enums.VehicleCategory;

public record VerifierDTO(VehicleCategory vehicleCategory, String UserName, String vehicleName, String vehicleNumber) {

}
