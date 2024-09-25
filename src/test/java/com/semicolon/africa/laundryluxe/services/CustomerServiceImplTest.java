package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.repository.CustomerRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testThatCustomerCanSignUp(){
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("David");
        signupCustomerRequest.setLastName("Esther");
        signupCustomerRequest.setEmail("david@gmail.com");
        signupCustomerRequest.setPhoneNumber("08169468242");
        signupCustomerRequest.setPassword("12345");
        signupCustomerRequest.setConfirmPassword("12345");
        SignUpCustomerResponse signUpCustomerResponse = customerService.signupCustomer(signupCustomerRequest);
        assertThat(signUpCustomerResponse).isNotNull();
        assertThat(signUpCustomerResponse.getMessage()).contains("Successfully signup");
    }
}