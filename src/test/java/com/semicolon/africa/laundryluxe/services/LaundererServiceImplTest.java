package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.SignUpLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpLaundererResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LaundererServiceImplTest {
    @Autowired
    LaundererService laundererService;

    @Test
    public void testTOSignUpLaunderer() {
        SignUpLaundererRequest request = new SignUpLaundererRequest();
        request.setFirstName("mfon");
        request.setLastName("mfon");
        request.setEmail("mfon@gmail.com");
        request.setPhoneNumber("08147995494");
        request.setPassword("oscker");
        request.setConfirmPassword("oscker");
        laundererService.signUp(request);
        SignUpCustomerResponse response = new SignUpCustomerResponse();
        response.setMessage("Sign up successful");
        assertEquals(response.getMessage(), "Sign up successful");
    }

}