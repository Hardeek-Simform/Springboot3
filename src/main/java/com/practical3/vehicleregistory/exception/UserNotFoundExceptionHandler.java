package com.practical3.vehicleregistory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userMissing(){
        log.info("User not found on search at UserController");
        return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserVehicleNotFound.class)
    public ResponseEntity<String> userVehicleNotFound(){
        log.info("Vehicle number not found on search at RegistryVerifier controller");
        return new ResponseEntity<>("Vehicle not registered", HttpStatus.NOT_FOUND);
    }
}
