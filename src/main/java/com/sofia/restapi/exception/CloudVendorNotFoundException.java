package com.sofia.restapi.exception;

public class CloudVendorNotFoundException extends RuntimeException{
    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public CloudVendorNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
}
