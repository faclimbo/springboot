package com.sofia.restapi.repository;

import com.sofia.restapi.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("V1",
                "Nike",
                "Nike Address",
                "093231321");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();

    }

    //Test Case Success
    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Nike");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    //Test Case Failure
    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Adidas");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}
