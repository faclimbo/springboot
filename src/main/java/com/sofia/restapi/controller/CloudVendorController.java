package com.sofia.restapi.controller;

import com.sofia.restapi.model.CloudVendor;
import com.sofia.restapi.response.ResponseHandler;
import com.sofia.restapi.service.CloudVendorService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
@ApiModel(description="this table holds cloud vendor information")//this annotation will put description of class in swagger
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Get Vendor by ID
    @GetMapping("/{vendorId}")
    @ApiOperation(value="cloud vendor id", notes="provide cloud vendor details",
                   response = ResponseEntity.class ) //this annotation will put description of method in swagger
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor details are given here",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    //Get All Id
    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }


    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable String vendorId) {

        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted";
    }


}
