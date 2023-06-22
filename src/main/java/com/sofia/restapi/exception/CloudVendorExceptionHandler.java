package com.sofia.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendoNotFoundException)
    {
        //payload of CloudVendorException
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendoNotFoundException.getMessage(),
                cloudVendoNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        //Returning the new ResponseEntity<>('payload', HttpStatus)
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
