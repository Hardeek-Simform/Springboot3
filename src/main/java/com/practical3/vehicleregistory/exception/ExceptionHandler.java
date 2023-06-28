package com.practical3.vehicleregistory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userMissing() {
        log.error("User not found");
        return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserVehicleNotFound.class)
    public ResponseEntity<String> userVehicleNotFound() {
        log.error("Vehicle number not found on search at RegistryVerifier controller");
        return new ResponseEntity<>("Vehicle not registered", HttpStatus.NOT_FOUND);
    }
}
