package com.practical3.vehicleregistory.entity.dto;

import com.practical3.vehicleregistory.entity.enums.VehicleCategory;

public record UserDTO(int billNo, String UserName, String vehicleName, String vehicleNumber,
                      VehicleCategory vehicleCategory) {
}
