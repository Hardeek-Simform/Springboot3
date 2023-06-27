package com.practical3.vehicleregistory.entity.enums;

import lombok.Getter;

public enum VehicleCategory {
    PETROL("Petrol"), DIESEL("Diesel"), CNG("CNG"), ELECTRIC("Electric");
    @Getter
    String vehicleCategory;

    VehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }
}
