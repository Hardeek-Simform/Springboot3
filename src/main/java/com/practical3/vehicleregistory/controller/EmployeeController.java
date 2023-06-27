package com.practical3.vehicleregistory.controller;

import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    private static int userListCall = 0;
    private static int deleteCall = 0;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<ArrayList<UserVehicle>> displayAllData() {
        userListCall++;
        log.info("inside EmployeeController, all data requested:" + userListCall);
        ArrayList<UserVehicle> vehicles = employeeService.displayAll();
        if (vehicles.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(vehicles));
    }

    @DeleteMapping("/delete/{billNo}")
    public void addUserVehicle(@PathVariable("billNo") int billNo) {
        deleteCall++;
        log.info("inside EmployeeController, total data deletion called:" + userListCall);
        employeeService.deleteEntry(billNo);
    }
}
