package com.practical3.vehicleregistory.controller;

import com.practical3.vehicleregistory.entity.dto.UserDTO;
import com.practical3.vehicleregistory.exception.UserNotFoundException;
import com.practical3.vehicleregistory.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private static int addCalled = 0;
    private static int viewAllCalled = 0;
    private static int viewCalled = 0;

    @Autowired
    UserService userService;

    @PostMapping
    public ArrayList<UserDTO> addUserVehicle(@RequestBody UserDTO userDTO) {
        addCalled++;
        log.info("Inside UserController, add called by user:" + addCalled);
        return userService.addData(userDTO);
    }

    @GetMapping
    public ArrayList<UserDTO> getAllUserVehicle() {
        viewAllCalled++;
        log.info("Inside UserController, view all called by user:" + viewAllCalled);
        return userService.getAllUserVehicles();
    }

    @GetMapping("/{billNo}")
    public UserDTO getUserVehicleByBillNo(@PathVariable("billNo") int billNo) {
        viewCalled++;
        log.info("Inside UserController, view called by user:" + viewCalled);
        UserDTO selectedUserVehicle = userService.getSelectedUserVehicle(billNo);
        log.info(String.valueOf(selectedUserVehicle));
        if (selectedUserVehicle == null) {
            throw new UserNotFoundException();
        } else {
            return selectedUserVehicle;
        }
    }
}
