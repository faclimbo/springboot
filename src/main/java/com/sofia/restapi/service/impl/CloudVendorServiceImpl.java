package com.sofia.restapi.service.impl;

import com.sofia.restapi.exception.CloudVendorNotFoundException;
import com.sofia.restapi.model.CloudVendor;
import com.sofia.restapi.repository.CloudVendorRepository;
import com.sofia.restapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // add here more business logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        /// add here more business logic
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // add here more business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // add here more business logic
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // add here more business logic
        return cloudVendorRepository.findAll();
    }
}
