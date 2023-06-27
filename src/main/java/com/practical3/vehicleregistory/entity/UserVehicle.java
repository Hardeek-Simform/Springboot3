package com.practical3.vehicleregistory.entity;

import com.practical3.vehicleregistory.entity.enums.VehicleCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVehicle {          //DTO access levels (Employee can access all)
    private int billNo;             // User
    private String UserName;        // user,verifier
    private String vehicleName;     // user,verifier
    private String vehicleNumber;   // user,verifier
    private VehicleCategory vehicleCategory;  // user,verifier
    private int registryId;         // none
    private String registryName;    // none
}